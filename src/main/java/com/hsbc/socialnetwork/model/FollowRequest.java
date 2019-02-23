package com.hsbc.socialnetwork.model;

import javax.validation.constraints.NotNull;

public class FollowRequest {

    @NotNull
    private Long whoId;

    @NotNull
    private Long toId;

    public FollowRequest() {

    }

    public Long getWhoId() {
        return whoId;
    }

    public void setWhoId(Long whoId) {
        this.whoId = whoId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }
}
