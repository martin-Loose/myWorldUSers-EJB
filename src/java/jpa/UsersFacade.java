/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marlo0212
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "myWorldUsers-EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public Users findByName(String name) {
   // List<Users> userList=new ArrayList<>();
   Users user=null; 
   try{
  //  userList=em.createNamedQuery("Users.findByUsername",Users.class)
    //        .setParameter("username", name).getResultList();
   user=em.createNamedQuery("Users.findByUsername",Users.class).setParameter("username", name).getSingleResult();
   }catch(Exception e){
       
    
    }
    return user;
    }

    @Override
    public List<Users> findByMail(String mail) {
       List<Users> userList=new ArrayList<>();
    try{
    userList=em.createNamedQuery("Users.findByEmail",Users.class)
            .setParameter("email", mail).getResultList();
    }catch(Exception e){
    
    }
    return userList;
    }

    @Override
    public List<Users> findByStartString(String searchString) {
      List<Users> userList=new ArrayList<>();
    try{
    userList=em.createNamedQuery("Users.findByStartString",Users.class)
            .setParameter("searchString", searchString).getResultList();
    }catch(Exception e){
    
    }
    return userList;
    }
    
}
