package com.example.bean;

import javax.persistence.*;

@Entity
public class Address {
    private int id;
    private String receiverName;
    private String addressInfo;
    private int postCode;
    private String tel;
    private int byUserid;
    private boolean isDefault;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "receiver_name")
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Basic
    @Column(name = "address_info")
    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    @Basic
    @Column(name = "post_code")
    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "is_default")
    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public int getByUserid() {
        return byUserid;
    }
    public void setByUserid(int byUserid) {
        this.byUserid = byUserid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (postCode != address.postCode) return false;
        if (byUserid != address.byUserid) return false;
        if (isDefault != address.isDefault) return false;
        if (receiverName != null ? !receiverName.equals(address.receiverName) : address.receiverName != null)
            return false;
        if (addressInfo != null ? !addressInfo.equals(address.addressInfo) : address.addressInfo != null) return false;
        return tel != null ? tel.equals(address.tel) : address.tel == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (receiverName != null ? receiverName.hashCode() : 0);
        result = 31 * result + (addressInfo != null ? addressInfo.hashCode() : 0);
        result = 31 * result + postCode;
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + byUserid;
        result = 31 * result + (isDefault ? 1 : 0);
        return result;
    }
}
