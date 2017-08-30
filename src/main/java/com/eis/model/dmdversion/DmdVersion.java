package com.eis.model.dmdversion;

import javax.persistence.*;

@Entity
@Table(name = "dmdversions")
public class DmdVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "product_id")
    private long productId;

    @Column(name = "name")
    private String name;
    @Column(name = "enabled")
    private Boolean enabled;

    public DmdVersion() {
    }

    public DmdVersion(long product_id, String name, Boolean enabled) {
        this.productId = product_id;
        this.name = name;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


}
