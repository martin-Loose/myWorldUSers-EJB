/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.service;

import entities.Users;
import javax.inject.Inject;
import jpa.UsersFacadeLocal;

/**
 *
 * @author marlo0212
 */
public class GetPath2PicService_EJB {
  private Users user;
  private String path2pic;
  private String docRoot;// http:127.0.0.1:8080/myWorld/   /// sollte aus db geholt werden
  private String subFolder; //username/Avatar/  /username/blog/
  private String subSubFolder;// /username/blog/blog_date/
  private String UPLOAD_DIRECTORY="Y:\\upload\\";/// sollte aus db geholt werden
  private String path2Avatar;
  private String path2UserPic;
  
  @Inject
  private UsersFacadeLocal usersFacadeLocal;
  //

    public Users getUser() {
        return user;
    }

    public void setUser(int id) {
        try{
            System.err.println("user set im path2pic");
         this.user = usersFacadeLocal.find(id);
         if(user.getAvatar()!=null){
             setDocRoot("http://grottenolm.hopto.org:8080/myWorld/");
             setPath2Avatar(getDocRoot()+user.getUsername()+"/Avatar/"+user.getAvatar());
             System.err.println("path2avatar im path2pic? "+getPath2Avatar());
         }
        }catch(Exception e){
         this.user = null;
        }
       
    }

    public String getPath2pic() {
        return path2pic;
    }

    public void setPath2pic(String path2pic) {
        this.path2pic = path2pic;
    }

    public String getDocRoot() {
        return docRoot;
    }

    public void setDocRoot(String docRoot) {
        this.docRoot = docRoot;
    }

    public String getSubFolder() {
        return subFolder;
    }

    public void setSubFolder(String subFolder) {
        this.subFolder = subFolder;
    }

    public String getSubSubFolder() {
        return subSubFolder;
    }

    public void setSubSubFolder(String subSubFolder) {
        this.subSubFolder = subSubFolder;
    }

    public String getPath2Avatar() {
        return path2Avatar;
    }

    public void setPath2Avatar(String path2Avatar) {
        this.path2Avatar = path2Avatar;
    }

    public String getPath2UserPic() {
        return path2UserPic;
    }

    public void setPath2UserPic(String path2UserPic) {
        this.path2UserPic = path2UserPic;
    }
  
}
