/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.create;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlo0212
 */
public class CreateFileAndFolderController_EJB {
    private String username; 
    private String subFolder="";
    private File f;
    private String fileName="";
    private boolean fileExist;
    private boolean folderExist;
    /**
     * hardcoded now, but should be from database
     */
    private final String UPLOAD__DIRECTORY = "Y:\\upload\\";

   public void prepareFolders(){
       List<String>folderList=new ArrayList<>();
       folderList.add("\\Avatar\\");
       folderList.add("\\Blog\\");
       folderList.add("\\Album\\");
       
       for(String s:folderList){
           setF(UPLOAD__DIRECTORY+getUsername()+s);
           if (!getF().exists()){
   f.mkdirs();
       System.err.println("dirs created");
       
   }
       }   
   
   }
   
   public void prepareFile() throws IOException{
       if(getSubFolder().length()!=0){
       setF(UPLOAD__DIRECTORY+getUsername()+"\\"+getSubFolder()+"\\"+getFileName());
       }else{
       setF(UPLOAD__DIRECTORY+getUsername()+"\\"+getFileName()+"\\");
       }
   
   if (!getF().exists()){
   f.createNewFile();
       System.err.println("file created");
       
   }
   }
   public String uploadString(){
   if(getSubFolder().length()!=0){
   return UPLOAD__DIRECTORY+getUsername()+"\\"+getSubFolder()+"\\"+getFileName();
   }else{
    return UPLOAD__DIRECTORY+getUsername()+"\\"+getFileName();
   }

   }
   public String PicString(){
   if(getSubFolder().length()!=0){
       System.err.println("im picstring: "+getUsername()+"/"+getSubFolder()+"/"+getFileName());
   return getUsername()+"/"+getSubFolder()+"/"+getFileName();
   }else{
        System.err.println("im picstring ohne sub: "+getUsername()+"/"+getSubFolder()+"/"+getFileName());
    return getUsername()+"/"+getFileName();
   }

   }
//

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubFolder() {
        return subFolder;
    }

    public void setSubFolder(String subFolder) {
        this.subFolder =subFolder;
        System.err.println("subfolder? "+this.subFolder);
        prepareFolders();
    }

    public File getF() {
        return f;
    }

    public void setF(String file) {
        this.f = new File(file);
    }

    public boolean isFileExist() {
        return fileExist;
    }


    public boolean isFolderExist() {
        try{
         if(getSubFolder().length()!=0){
        setF(UPLOAD__DIRECTORY+getUsername()+"\\"+getSubFolder()+"\\");
        }else{
            setF(UPLOAD__DIRECTORY+getUsername()+"\\");
        }
        }catch(Exception e){
        
        }
       
        return getF().exists();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    
}
