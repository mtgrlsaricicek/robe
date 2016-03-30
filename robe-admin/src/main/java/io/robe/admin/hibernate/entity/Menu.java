package io.robe.admin.hibernate.entity;

import io.robe.hibernate.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Menu extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String text;

    @Column(length = 50, nullable = false)
    private String path;

    @Column(name = "itemIndex")
    private int index;

    @Column(length = 32)
    private String parentOid;

    @Column
    private String module;

    @Column
    private String icon;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getParentOid() {
        return parentOid;
    }

    public void setParentOid(String parentOid) {
        this.parentOid = parentOid;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
