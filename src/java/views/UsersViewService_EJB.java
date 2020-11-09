/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jpa.UsersFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class UsersViewService_EJB {
    private String username;
    private Users selectedUser;
    private List<Users> userList=new ArrayList<>();
    private boolean toShow=false;
    private String searchString;
    @Inject
    private UsersFacadeLocal usersFacade;

    public String getUsername() {
        return username;
    }
public void resetSelectedUser(){
    setToShow(false);
    setSelectedUser(null);
    
}
    public void setUsername(String username) {
        this.username = username;
    }

    public Users getSelectedUser() {
        return selectedUser;
    }

    public String setSelectedUser(Users selectedUser) {
       
        this.selectedUser = selectedUser;
        return "/secured/user/userDetails?faces-redirect=true";//"/secured/user/userIndex?faces-redirect=true";
    }

    public List<Users> getUserList() {
        try{
          if(isToShow()==false){ 
        return usersFacade.findAll();
          }else if(isToShow()==true){
          return usersFacade.findByStartString(searchString);
          }
        }catch(Exception e){
        
        }
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }
 public boolean isToShow() {
        return toShow;
    }

    public void setToShow(boolean toShow) {
        this.toShow = toShow;
    }
    
    
  public void findbyStart(){
      System.err.println("search: "+usersFacade.findByStartString(searchString).size());
      if(getSearchString().contains(" ")==true){
      setToShow(false);
      }else{
      setToShow(true);}
      getUserList();
  } 

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
  
}
