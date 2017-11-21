/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.repository;

import org.springframework.data.repository.CrudRepository;
import sawbonadev.cafe.model.projects.ActivityStatus;

/**
 *
 * @author sawbona
 */
public interface ActivityStatusDao extends CrudRepository<ActivityStatus, Long>{
    
    
    
}
