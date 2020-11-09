/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Users;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jpa.UsersFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class LoginController_EJB {

    private String username;
    private String passwort;
    private String email;

    private Users authenticatedUser;
    private static final long serialVersionUID = 3254181235309041386L;
    private static final Logger log = Logger.getLogger(LoginController_EJB.class.getName());
    @Inject
    private UsersFacadeLocal userEJB;

//---------------------------------------------------------------
    private String userDataHeader = "";
//***************************************************************        
    private String tempLink;

    public String login() {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(username, passwort);
            Principal principal = request.getUserPrincipal();
            setAuthenticatedUser(userEJB.findByName(principal.getName()));
            request.getSession().setAttribute("username", authenticatedUser.getUsername());
            System.out.println("Login 2 " + " -- " + request.getSession().getAttribute("username").toString() + "");
            request.getSession().setAttribute("username", getAuthenticatedUser().getUsername());
            if (request.isUserInRole("users")) {
                System.out.println("logged in - eigentlich");
                return "/secured/user/userIndex?faces-redirect=true";
            } else if (request.isUserInRole("admin")) {
                return "/secured/admin/adminIndex?faces-redirect=true";
            } else if (request.isUserInRole("masteradmin")) {
                return "/secured/admin/masteradminIndex?faces-redirect=true";
            } else {
                return "/public/publicIndex?faces-redirect=true";
            }
        } catch (ServletException e) {
            if (e.getMessage().contains("already")) {
                logMEout();
                login();
            }
            System.err.println("eee " + e.getMessage());
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed! Bitte prüfe die Schreibweise von email und passwort", null));

        }
        //*****************************************************
        /**
         * if (user.getBolActivate() == true) { log.info("Authentication done
         * for user: " + principal.getName());
         * request.getSession().setAttribute("username", user.getUsername()); //
         * ExternalContext externalContext =
         * FacesContext.getCurrentInstance().getExternalContext(); //
         * Map<String, Object> sessionMap = externalContext.getSessionMap(); //
         * sessionMap.put("User", user); //
         * whoIsOnline.addUser(request.getSession().getAttribute("username").toString(),
         * request.getSession().getId()+"");
         *
         * if (request.isUserInRole("users")) { System.out.println("logged in -
         * eigentlich"); return "/secured/user/user_index?faces-redirect=true";
         * } else if (request.isUserInRole("admin")) { return
         * "/secured/admin/admin_index?faces-redirect=true"; } else if
         * (request.isUserInRole("masteradmin")) { return
         * "/secured/admin/masteradmin_index?faces-redirect=true"; } else {
         * return "/public/index?faces-redirect=true"; }
         *
         * } else { return "/public/nichtaktiviert?faces-redirect=true";
        }*
         */

        return null;
    }

    public String logMEout() {
        System.out.println("im logoff");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {

            System.out.println("logoff: \n"
                    + getAuthenticatedUser().getUsername() + "\n"
                    + request.getSession().getId() + "\n"
                    + request.getSession().getAttribute("username") + " loggt aus");
//                        whoIsOnline.removeUser(request.getSession().getAttribute("username").toString());

            request.logout();//getSession().invalidate();
            // clear the session
            ((HttpSession) context.getExternalContext().getSession(false)).invalidate();
            setAuthenticatedUser(new Users());

        } catch (ServletException e) {
            setAuthenticatedUser(new Users());
            log.log(Level.SEVERE, "Failed to logout user!", e);
        }
        return "/public/publicIndex?faces-redirect=true";
    }

    public Users getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setAuthenticatedUser(Users authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
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

    public String getTempLink() {
        return tempLink;
    }

    public void setTempLink(String tempLink) {

        // this.tempLink = "http://grottenolm.hopto.org:8080/myQuizBattle/activate=" + tempLink.trim();
        List<Users> alle = new ArrayList();
        try {
            //    this.user = null;
            alle = userEJB.findAll();
            /**
             * * for (Users q : alle) { System.out.println("email: " +
             * q.getActivatelink() + "\nemail " + q.getEmail()); if
             * (q.getActivatelink().trim().equals(tempLink)) {
             * setEmail(q.getEmail()); System.out.println("treffer: linki " +
             * tempLink + " QQQ: " + q.getEmail()); System.out.println("im
             * login: " + tempLink); System.out.println("......... " +
             * this.tempLink.length()); }
            }*
             */

        } catch (Exception e) {
            System.out.println("exception: " + e);
        }
    }

    public String gettLink() {
        return tempLink;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
