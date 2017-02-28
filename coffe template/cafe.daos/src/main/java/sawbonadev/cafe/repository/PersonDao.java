/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.repository;

import org.springframework.data.repository.CrudRepository;
import sawbonadev.cafe.model.person.PersonDetail;

/**
 *
 * @author sawbona
 */
public interface PersonDao extends CrudRepository<PersonDetail, Long>{
    
//    @PersistenceContext
//    private EntityManager entityManager;
//    
//     public void save(PersonDetail persona){
//        System.out.println("Guardando...");
////        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
////        EntityManager entityManager = entityManagerFactory.createEntityManager();
////        entityManager.getTransaction().begin();
//        entityManager.persist(persona);
////        entityManager.persist(new Event("A follow up event", new Date()));
////        entityManager.getTransaction().commit();
////        entityManager.close();
//    }
    
}
