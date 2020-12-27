/*
 * UploadController.java
 * Created by Murad R. Imanbayli <muradimanbayli at gmail.com> on Jun 15, 2016  5:34:30 PM
 * Copyright www.imanbayli.net 2016.All rights reserved
 */
package controller.upload;

import controller.create.CreateFileAndFolderController_EJB;
import entities.Users;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.inject.Inject;
import javax.servlet.http.Part;
import jpa.UsersFacadeLocal;

/**
 *
 * @author Murad R. Imanbayli <muradimanbayli at gmail.com>
 */
public class UploadController_EJB {

    private Part image;

    private String pathToPic;
    private String username;
    private String subFolder;
    private HoldImageController_EJB holdImage;
    private CreateFileAndFolderController_EJB createFileAndFolder;

    @Inject
    private UsersFacadeLocal usersFacade;

    public UploadController_EJB() {
        holdImage = new HoldImageController_EJB();
        createFileAndFolder = new CreateFileAndFolderController_EJB();

    }

    public void test() {
        try {
            holdImage.setImage(image);
        } catch (Exception e) {
            System.err.println("test error");
        }
    }

    public String doUpload(String username, String folderName) {
        try {
            createFileAndFolder.setUsername(username);
            setUsername(username);
            if (folderName.length() != 0) {
                setSubFolder(subFolder);
                createFileAndFolder.setSubFolder(folderName);
                if (createFileAndFolder.isFolderExist() == false) {
                    createFileAndFolder.prepareFolders();
                }
            }
 createFileAndFolder.setFileName(getFilename(holdImage.getImage()));
            createFileAndFolder.setF(createFileAndFolder.uploadString());
            createFileAndFolder.prepareFile();
            holdImage.setImage(image);
            setImage(holdImage.getImage());
            
            
            InputStream in = getImage().getInputStream();
     
            FileOutputStream out = new FileOutputStream(createFileAndFolder.getF());

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();
            Users user=new Users();
            user=usersFacade.findByName(username);
            user.setAvatar(getFilename(holdImage.getImage()));
            usersFacade.edit(user);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
return "userIndex.xhtml?faces-redirect=true";
    }

    public Part getImage() {
        System.err.println("image get");
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
        System.err.println("image set");
    }

    public String getPathToPic() {
       try{
      return "http://localhost:8080/myWorld/"+createFileAndFolder.PicString();
        
                
       }catch(Exception e){
           System.err.println("eeeeee "+e.getMessage());
            return null;
       }
}

    public void setPathToPic(String pathToPic) {
        this.pathToPic = pathToPic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private static String getFilename(Part part) {
        String uploadName = "";
        if (part.getSubmittedFileName().contains("\\")) {
            uploadName = "" + part.getSubmittedFileName().subSequence(part.getSubmittedFileName().lastIndexOf("\\") + 1,
                    part.getSubmittedFileName().length());
            return uploadName;
        } else {
            return part.getSubmittedFileName();
        }

    }

    public String getSubFolder() {
        return subFolder;
    }

    public void setSubFolder(String subFolder) {
        this.subFolder = subFolder;
    }
    
}
/**
 * File f=new File(UPLOAD__DIRECTORY+getUsername()); if(!f.exists()){ f.mkdir();
 * } f=new File(UPLOAD__DIRECTORY+getUsername()+"\\"+getFilename(getImage()));
 * if(!f.exists()){ f.createNewFile();
 *
 * }*
 */
