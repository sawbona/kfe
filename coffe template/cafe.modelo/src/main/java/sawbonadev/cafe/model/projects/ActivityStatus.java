/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.model.projects;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import sawbonadev.cafe.model.utils.Lengths;

/**
 *
 * @author sawbona
 */
@Table(name = "ActivityStatus")
@Entity
public class ActivityStatus implements Serializable {
    
    @Id
    @Column(name = "idActivityStatus")
    private long idActivityStatus;
    
    @Column(length = Lengths.SMALL, nullable = false)
    private String description;

    public ActivityStatus() {
    }

    public ActivityStatus(long idActivityStatus, String description) {
        this.idActivityStatus = idActivityStatus;
        this.description = description;
    }
    
    public long getIdActivityStatus() {
        return idActivityStatus;
    }

    public void setIdActivityStatus(long idActivityStatus) {
        this.idActivityStatus = idActivityStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
