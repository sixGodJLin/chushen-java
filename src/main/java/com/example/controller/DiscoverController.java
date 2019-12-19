package com.example.controller;

import com.example.bean.Discover;
import com.example.dao.DiscoverDao;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.collections.IteratorUtils;

import java.util.List;

@RestController
@RequestMapping("/discover")
public class DiscoverController {
    private final DiscoverDao discoverDao;

    public DiscoverController(DiscoverDao discoverDao) {
        this.discoverDao = discoverDao;
    }

    @GetMapping()
    public List<Discover> getDiscover () {
        @SuppressWarnings("unchecked")
        List<Discover> discovers = IteratorUtils.toList(discoverDao.findAll().iterator());
        discovers.sort((Discover a, Discover b) ->
                        a.getCreateTime().getTime() > b.getCreateTime().getTime() ? -1 : 1);
        return discovers;
    }

    @PostMapping()
    public void addDiscover (@RequestBody Discover discover) {
        System.out.println(discover);
        discoverDao.save(discover);
    }

    @PatchMapping()
    public void patchDiscover(@RequestBody Discover discover) {
        System.out.println("---> " + discover.toString());
        discoverDao.save(discover);
    }

    @DeleteMapping("/{id}")
    public Integer deleteDiscover(@PathVariable("id") Integer id) {
        discoverDao.delete(id);
        return id;
    }
}
