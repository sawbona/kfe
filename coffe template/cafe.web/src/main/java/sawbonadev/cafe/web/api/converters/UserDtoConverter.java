/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.api.converters;

import org.springframework.core.convert.converter.Converter;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.web.api.users.model.UserDto;

/**
 *
 * @author sawbona
 */
public class UserDtoConverter implements Converter<User, UserDto>{

    @Override
    public UserDto convert(User s) {
        return new UserDto(s.getEmail());
    }
    
}
