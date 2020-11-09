/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.UsersGroups;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlo0212
 */
@Stateless
public class UsersGroupsFacade extends AbstractFacade<UsersGroups> implements UsersGroupsFacadeLocal {

    @PersistenceContext(unitName = "myWorldUsers-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersGroupsFacade() {
        super(UsersGroups.class);
    }
    
}
