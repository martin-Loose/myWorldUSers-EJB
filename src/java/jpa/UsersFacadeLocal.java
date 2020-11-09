/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface UsersFacadeLocal {

    void create(Users users);

    void edit(Users users);

    void remove(Users users);

    Users find(Object id);

    List<Users> findAll();

    List<Users> findRange(int[] range);

    int count();
    /**
     * 
     * @param name SQL-Parameter WHERE username==name
     * @return Users user
     */
    Users findByName(String name);
    List<Users> findByMail(String mail);
    List<Users> findByStartString(String searchString);
}
