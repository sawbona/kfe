/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import sawbonadev.cafe.model.utils.Lengths;

/**
 *
 * @author sawbona
 */
@MappedSuperclass
public class PublicEntity {
    
    @Column(name = "publicId", length = Lengths.SMALL, unique = true, nullable = false)
    private String publicId;

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }
    
}
