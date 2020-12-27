/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Userprofile;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface UserprofileFacadeLocal {

    void create(Userprofile userprofile);

    void edit(Userprofile userprofile);

    void remove(Userprofile userprofile);

    Userprofile find(Object id);

    List<Userprofile> findAll();

    List<Userprofile> findRange(int[] range);

    int count();
    
}
