package com.pinyougou.pojo;

import java.io.Serializable;

public class BrefPro implements Serializable {
    private Integer bpId;

    private String bpType;

    private String bpUrl;

    private String bpHuohao;

    private String bpPrice;

    public Integer getBpId() {
        return bpId;
    }

    public void setBpId(Integer bpId) {
        this.bpId = bpId;
    }

    public String getBpType() {
        return bpType;
    }

    public void setBpType(String bpType) {
        this.bpType = bpType == null ? null : bpType.trim();
    }

    public String getBpUrl() {
        return bpUrl;
    }

    public void setBpUrl(String bpUrl) {
        this.bpUrl = bpUrl == null ? null : bpUrl.trim();
    }

    public String getBpHuohao() {
        return bpHuohao;
    }

    public void setBpHuohao(String bpHuohao) {
        this.bpHuohao = bpHuohao == null ? null : bpHuohao.trim();
    }

    public String getBpPrice() {
        return bpPrice;
    }

    public void setBpPrice(String bpPrice) {
        this.bpPrice = bpPrice == null ? null : bpPrice.trim();
    }
}