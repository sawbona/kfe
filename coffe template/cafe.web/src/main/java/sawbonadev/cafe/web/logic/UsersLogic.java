/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sawbonadev.cafe.repository.UserDao;
import sawbonadev.cafe.model.person.PersonDetail;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.web.api.converters.UserDtoConverter;
import sawbonadev.cafe.web.api.users.model.UserDto;
import sawbonadev.solo.GenericResponse;
import sawbonadev.cafe.web.views.CreateAccountView;
import sawbonadev.solo.strings.ValidateUtils;

/**
 *
 * @author sawbona
 */
@Service
public class UsersLogic {

    @Autowired
    private UserDao usersDao;
    
    private final UserDtoConverter userDtoConverter = new UserDtoConverter();

    public GenericResponse<CreateAccountView> validate(final CreateAccountView view) {
        GenericResponse<CreateAccountView> validations = new GenericResponse<>(view);
        validations.add("email", "Email is required.", ValidateUtils.STRINGS_REQUIRED, view.getEmail());

        // if email is present validate for email already registered.
        if (validations.isValid()) {
            User finded = usersDao.findByEmail(view.getEmail());
            if (finded != null) {
                validations.addValidationMessageForProperty("duplicatedEmail",
                        "Email is already registered.");
            }
        }
        validations.add("email", "Enter a valid email.",
                ValidateUtils.VALID_EMAIL, view.getEmail());
        validations.add("password", "Password is required.",
                ValidateUtils.STRINGS_REQUIRED, view.getPassword());
        validations.add("passwordConfirm", "Password confirmation is required.",
                ValidateUtils.VALID_EMAIL, view.getPasswordConfirm());

        // validate password and confirmation.
//        if (new StringsRequired(vista.getPassword(), vista.getPasswordConfirm()).isValid()) {
//            validations.add("passwordNotMatch",
//                    "Las contraseñas no coinciden.",
//                    new StringsEquals(vista.getPassword(), vista.getPasswordConfirm()));
//        }
//        if (new StringsRequired(vista.getPassword()).isValid()) {
//            validations.add("passwordInsecure",
//                    "La contraseña no cumple los requisitos de seguridad.",
//                    new StringsSecurePassword(vista.getPassword()));
//        }

        return validations;
    }

    @Transactional
    public GenericResponse<CreateAccountView> save(CreateAccountView vista) {
        GenericResponse<CreateAccountView> validations = validate(vista);
        if (validations.isValid()) {
            final User usuario = new User();
            usuario.setEmail(vista.getEmail());
            usuario.setPassword(vista.getPassword());
            usuario.setPerson(new PersonDetail());
            usersDao.save(usuario);
        }
        return validations;
    }
    

    public GenericResponse<Page<UserDto>> list(int p, int ps) {
        Page<User> findAll = usersDao.findAll(new PageRequest(p, ps));
        Page<UserDto> dtos = findAll.map(userDtoConverter);
        return new GenericResponse(dtos);
    }

    @Transactional
    public GenericResponse<UserDto> delete(String email) {
        User findOne = usersDao.findByEmail(email);
        usersDao.delete(findOne);
        return new GenericResponse<>(userDtoConverter.convert(findOne));
    }

}
