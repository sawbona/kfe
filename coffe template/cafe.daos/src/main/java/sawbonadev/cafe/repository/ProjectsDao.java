/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import sawbonadev.cafe.model.projects.Project;

/**
 *
 * @author sawbona
 */
public interface ProjectsDao extends PagingAndSortingRepository<Project, Long> {

    List<Project> findByOwnerEmail(String email);
}
