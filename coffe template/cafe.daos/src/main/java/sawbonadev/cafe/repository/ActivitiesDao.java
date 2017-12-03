/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import sawbonadev.cafe.model.projects.Activity;

/**
 *
 * @author sawbona
 */
public interface ActivitiesDao extends PagingAndSortingRepository<Activity, Long> {
    
    @Modifying
    @Query("DELETE from Activity a WHERE a in (SELECT aq FROM Activity aq where"
            + " aq.activityId = (:id) and aq.createdBy.email = (:email))")
    int deleteByIdAndUser(@Param("id") long id, @Param("email") String userEmail);
    
}
