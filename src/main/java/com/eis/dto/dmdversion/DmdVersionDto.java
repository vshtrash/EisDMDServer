package com.eis.dto.dmdversion;


public class DmdVersionDto {
    private long id;
    private long productId;

    private String name;
    private Boolean enabled;

    public DmdVersionDto() {
    }

    public DmdVersionDto(long id, long productId, String name, Boolean enabled) {
        this.id = id;
        this.enabled = enabled;
        this.name = name;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
