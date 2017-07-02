/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sawbonadev.cafe.model.projects.Activity;

/**
 *
 * @author sawbona
 */
public interface ActivitiesDao extends PagingAndSortingRepository<Activity, Long> {
    
}
