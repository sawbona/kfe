/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sawbonadev.cafe.model.person.User;

/**
 *
 * @author sawbona
 */
public interface UserDao extends PagingAndSortingRepository<User, Long>{
    User findByEmail(String email);
}
