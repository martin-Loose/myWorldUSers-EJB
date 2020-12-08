/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import entities.Whoisonline;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author marlo0212
 */
@Local
public interface WhoisonlineFacadeLocal {

    void create(Whoisonline whoisonline);

    void edit(Whoisonline whoisonline);

    void remove(Whoisonline whoisonline);

    Whoisonline find(Object id);

    List<Whoisonline> findAll();

    List<Whoisonline> findRange(int[] range);

    int count();
    //***************
     Whoisonline findByUserID(int userID);
     List<Whoisonline> findChatroomsWithUser(int userID);
      List<Whoisonline> findUsersByChatroom(int chatRoomID);
}
