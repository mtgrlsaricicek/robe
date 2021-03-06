package io.robe.admin.hibernate.entity;

import io.robe.hibernate.entity.BaseEntity;
import io.robe.quartz.info.JobInfoProvider;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JobInfo")
public class HJobInfo extends BaseEntity {

    private String name;

    private String jGroup;

    private Class<? extends org.quartz.Job> jobClass;

    private String description;

    private Class<? extends JobInfoProvider> provider;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Class<? extends org.quartz.Job> getJobClass() {
        return jobClass;
    }

    public void setJobClass(Class<? extends org.quartz.Job> jobClass) {
        this.jobClass = jobClass;
    }

    public Class<? extends JobInfoProvider> getProvider() {
        return provider;
    }

    public void setProvider(Class<? extends JobInfoProvider> provider) {
        this.provider = provider;
    }

    public String getGroup() {
        return jGroup;
    }

    public void setGroup(String group) {
        this.jGroup = group;
    }
}
