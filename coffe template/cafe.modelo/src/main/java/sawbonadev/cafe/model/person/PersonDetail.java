/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.model.person;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author sawbona
 */
@Entity
@Table(name = "PeopleDetails")
public class PersonDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personId")
    private long personId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "secondName", length = 100)
    private String secondName;

    @Column(name = "lastName", length = 100)
    private String lastName;

    @Column(name = "birthDay")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDay;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long idPersona) {
        this.personId = idPersona;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthDay;
    }

    public void setBirthday(Date fechaNacimiento) {
        this.birthDay = fechaNacimiento;
    }

}
