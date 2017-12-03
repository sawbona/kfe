/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.model.projects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.model.utils.Lengths;

/**
 *
 * @author sawbona
 */
@Entity
public class Activity implements Serializable {
    
    @ManyToOne(optional = false)
    private Project project;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private ActivityStatus status = new ActivityStatus();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "activityId")
    private long activityId;
    
    @Column(name = "name", nullable = false, length = Lengths.SMALL)
    private String name;
    
    @Column(name = "description", nullable = true, length = Lengths.MEDIUM)
    private String description;
    
    @Column(name = "owner", length = Lengths.SMALL)
    private String owner;
    
    @ManyToOne(optional = false)
    private User createdBy;
    
    @OneToMany(mappedBy = "parent")
    private List<Activity> activities;
    
    @ManyToOne
    private Activity parent;

    public Activity() {
        this.activities = new ArrayList<>();
    }

    public Activity getParent() {
        return parent;
    }

    public void setParent(Activity parent) {
        this.parent = parent;
    }
    
    // getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActivityStatus getStatus() {
        return status;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }
    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    /**
     * @return the activities
     */
    public List<Activity> getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

}
