/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.model.installation;

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
@Entity
@Table(name = "InstallationProperties")
public class InstallationProperty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "installation_property_id")
    private long installationPropertyId;
    
    @Column(name = "keyName", length = Lengths.SMALL, nullable = false, unique = true)
    private String keyName;
    
    @Column(name = "keyValue", length = Lengths.SMALL)
    private String keyValue;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public long getInstallationPropertyId() {
        return installationPropertyId;
    }

    public void setInstallationPropertyId(long installationPropertyId) {
        this.installationPropertyId = installationPropertyId;
    }
    
     
}
