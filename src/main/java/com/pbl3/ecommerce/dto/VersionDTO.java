package com.pbl3.ecommerce.dto;

public class VersionDTO {
    String versionName;

    public String getVersionName() {
        return versionName;
    }

    public VersionDTO(String versionname){
        this.versionName = versionname;
    }
    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}
