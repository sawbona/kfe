/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import sawbonadev.cafe.model.projects.Project;

/**
 *
 * @author sawbona
 */
public interface ProjectsDao extends PagingAndSortingRepository<Project, Long> {

    Page<Project> findByOwnerEmail(String email, Pageable pageRequest);
}
