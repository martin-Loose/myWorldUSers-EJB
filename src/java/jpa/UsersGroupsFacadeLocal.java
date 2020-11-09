/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.UsersGroups;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface UsersGroupsFacadeLocal {

    void create(UsersGroups usersGroups);

    void edit(UsersGroups usersGroups);

    void remove(UsersGroups usersGroups);

    UsersGroups find(Object id);

    List<UsersGroups> findAll();

    List<UsersGroups> findRange(int[] range);

    int count();
    
}
