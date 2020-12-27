/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Userpics;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface UserpicsFacadeLocal {

    void create(Userpics userpics);

    void edit(Userpics userpics);

    void remove(Userpics userpics);

    Userpics find(Object id);

    List<Userpics> findAll();

    List<Userpics> findRange(int[] range);

    int count();
    
}
