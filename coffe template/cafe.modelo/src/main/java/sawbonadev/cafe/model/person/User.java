/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.model.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import sawbonadev.cafe.model.users.Role;

/**
 *
 * @author sawbona
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 500, nullable = false)
    private String password;

    /**
     * A un usuario se le agrega la informacion de su persona. Cuando se
     * registra se puede inicializar como null los campos de la persona pero se
     * debe de crear. Cuando eliminar un usuario no eliminamos la informacion de
     * la persona?
     */
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    private PersonDetail person;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long idUsuario) {
        this.userId = idUsuario;
    }

    public PersonDetail getPerson() {
        return person;
    }

    public void setPerson(PersonDetail persona) {
        this.person = persona;
    }

}
