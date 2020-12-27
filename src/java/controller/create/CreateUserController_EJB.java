/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.create;

import entities.Users;
import entities.UsersGroups;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.UsersFacadeLocal;
import jpa.UsersGroupsFacadeLocal;
import util.AuthenticationUtils;

/**
 *
 * @author marlo0212
 */
public class CreateUserController_EJB {

    private String username;
    private String email;
    private String passwort;
    private String confirmPasswort;

    //
   
    //
    private int usercount;
    @Inject
    private UsersFacadeLocal usersFacadeLocal;
@Inject
private UsersGroupsFacadeLocal usersGroups;
    private Users newUser;

    public String createUser() {
        try {
            if(usersFacadeLocal.findByName(username)!=null){
                    FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Username vergeben", "Username vergeben"));
                } 
                if(!usersFacadeLocal.findByMail(email).isEmpty()){
                    FacesContext.getCurrentInstance().addMessage(null,
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "email vergeben", "email vergeben"));    
                }
         
                if (usersFacadeLocal.findByName(username)==null
                        && usersFacadeLocal.findByMail(email).isEmpty()
                        && passWordMatchConfirm()==true) {
                    newUser = new Users();
                    newUser.setEmail(email);                    
                    newUser.setPassword(AuthenticationUtils.encodeSHA256(passwort));
                     newUser.setUsername(username);
                    usersFacadeLocal.create(newUser);
                    CreateFileAndFolderController_EJB creatFileAndFolder=new CreateFileAndFolderController_EJB();
                    creatFileAndFolder.setUsername(username);
                    UsersGroups usersGroup =new UsersGroups();
                    usersGroup.setGruppenname("users");
                    usersGroup.setUserid(username);
                    usersGroups.create(usersGroup);
                    creatFileAndFolder.prepareFolders();
                    System.err.println("username: "+username + " email: "+email + "passwort: "+passwort);
                    return "/public/regdone?faces-redirect=true";
                } 
        } catch (Exception e) {
 return "/public/publicIndex?faces-redirect=true";
        }
 return null;
    }
//
public boolean checkName(String username){
boolean check=false;
try{

}catch(Exception e){

}
    return check;
}

public boolean passWordMatchConfirm(){
boolean check=false;
try{
check=passwort.equals(confirmPasswort);
if(check==true){
}else if(!passwort.equals(confirmPasswort)){
           FacesContext.getCurrentInstance().addMessage("formUserInput:pwd2",
                             new FacesMessage(FacesMessage.SEVERITY_FATAL, "Passwords dont match", "Passwoerter ungleich"));
         
}
}catch(Exception e){

}
return check;
}
//
    public int getUsercount() {
        try {
            return usersFacadeLocal.count();
        } catch (Exception e) {
            return usercount;
        }

    }

    public void setUsercount(int usercount) {
        this.usercount = usercount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getConfirmPasswort() {
        return confirmPasswort;
    }

    public void setConfirmPasswort(String confirmPasswort) {
        this.confirmPasswort = confirmPasswort;
    }

   
    
}
