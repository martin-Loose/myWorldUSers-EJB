/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Users;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.UserpicsFacadeLocal;
import jpa.UsersFacadeLocal;
import util.AuthenticationUtils;

/**
 *
 * @author marlo0212
 */
public class EditUserBaseDataController_EJB {

    private String email;
    private String password;
    private String confirmPassword;
    private int userID;
    private String userName;
    private Users user;
    private boolean changeEmail;
    private boolean changeAvatar;
    private boolean changePassword;
private String strAvatarPath="http://grottenolm.hopto.org:8080/myWorld/";
    @Inject
    private UsersFacadeLocal usersFacadeLocal;
    @Inject
    private UserpicsFacadeLocal userPicFacade;

    private LoginController_EJB login;

    public String updateUserData() {
        try {
   /**         setUserID(Integer.parseInt(FacesContext.getCurrentInstance()
                    .getExternalContext().getRequestParameterMap().get("userID")));
      **/     
            if (!usersFacadeLocal.findByMail(email).isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "email vergeben", "email vergeben"));
            }

            if (changePassword == true && passWordMatchConfirm() == true) {
                user.setPassword(AuthenticationUtils.encodeSHA256(password));
                usersFacadeLocal.edit(user);
            }
            if (changeEmail == true && usersFacadeLocal.findByMail(email).isEmpty()) {
                user.setEmail(email);
                usersFacadeLocal.edit(user);
            }
            login.setAuthenticatedUser(usersFacadeLocal.find(userID));
            
            return "/secured/user/users/userIndex.xhtml?faces-redirect=true";

        } catch (Exception e) {
            return "/secured/user/users/userIndex.xhtml?faces-redirect=true";
        }

    }

    public boolean passWordMatchConfirm() {
        boolean check = false;
        try {
            check = password.equals(confirmPassword);
            if (check == true) {
            } else if (!password.equals(confirmPassword)) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL, "Passwords dont match", "Passwoerter ungleich"));

            }
        } catch (Exception e) {

        }
        return check;
    }
    //

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(int id) {
        this.user = usersFacadeLocal.find(id);
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        setConfirmPassword(user.getPassword());
        System.err.println("user set: " + user.getEmail());
    }

    public boolean isChangeEmail() {
        return changeEmail;
    }

    public void setChangeEmail(boolean changeEmail) {
        if(changeEmail==false){
            setEmail(getUser().getEmail());
        }
        this.changeEmail = changeEmail;
    }

    public boolean isChangeAvatar() {
        return changeAvatar;
    }

    public void setChangeAvatar(boolean changeAvatar) {
        this.changeAvatar = changeAvatar;
    }

    public boolean isChangePassword() {
        return changePassword;
    }

    public void setChangePassword(boolean changePassword) {
        if(changePassword==false){
            setPassword(null);
            setConfirmPassword(null);
            passWordMatchConfirm();
        }
        this.changePassword = changePassword;
    }
public void setCancelEmail(){
    setChangeEmail(false);
    setEmail(user.getEmail());
}

    public String getStrAvatarPath() {
        return strAvatarPath+getUserName()+"/Avatar/";
    }

    public void setStrAvatarPath(String strAvatarPath) {
        this.strAvatarPath = strAvatarPath;
    }

}
