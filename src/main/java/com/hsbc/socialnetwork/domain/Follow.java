package com.hsbc.socialnetwork.domain;

import javax.persistence.*;

@Entity(name = "Follow")
public class Follow extends Base {

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "who_id")
    private User who;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "to_id")
    private User to;


    public Follow() {
        super();
    }

    public User getWho() {
        return who;
    }

    public void setWho(User who) {
        this.who = who;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

}
