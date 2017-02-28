/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.api.users;

import sawbonadev.cafe.web.api.users.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sawbonadev.cafe.web.logic.UsersLogic;
import sawbonadev.solo.GenericResponse;

/**
 *
 * @author clobaco
 */
@RestController
@RequestMapping(value = "/api/users")
@Secured("ROLE_ADMIN")
public class UsersApi {

    @Autowired
    private UsersLogic usersLogic;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity get(
            @RequestParam(value = "p", defaultValue = "0") int page,
            @RequestParam(value = "ps", defaultValue = "10") int pageSize) {
        final GenericResponse<Page<UserDto>> list = usersLogic.list(page, pageSize);
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{email:.+}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("email") String email){
        System.out.println("email = " + email);
        GenericResponse<UserDto> delete = usersLogic.delete(email);
        ResponseEntity<GenericResponse<UserDto>> response = ResponseEntity.ok().body(delete);
        return response;
    }

}
