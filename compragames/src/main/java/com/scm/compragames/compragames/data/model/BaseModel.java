package com.scm.compragames.compragames.data.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.envers.Audited;

import java.util.Date;

@MappedSuperclass
@Audited
public class BaseModel {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    @org.springframework.data.annotation.Id
    private Long id;
    @Column(name = "ACTIVE", nullable = false)
    private Boolean active = Boolean.TRUE;
    @JsonIgnore
    @Column(name = "VERSION")
    @Version
    private Long version = 0L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
