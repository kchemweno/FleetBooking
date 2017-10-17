package fleet.model;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.client.Configuration;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Sep 21 16:00:48 EAT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LoginUsersViewImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public LoginUsersViewImpl() {
    }
        
    public boolean changePassword(String oldPassword, String newPassword){
        boolean isPasswordChanged = false;
        ApplicationModule appMod=null;
        LoginUsersViewImpl vo;
        LoginUsersViewRowImpl row;
        String username = "";
        try{
            username = UsersViewImpl.getLoggedInUsername();
            System.err.println(username);
            appMod = Configuration.createRootApplicationModule("fleet.model.AppModule", "AppModuleFleetLocal");
            vo = (LoginUsersViewImpl)appMod.findViewObject("LoginUsersView1");
            ViewCriteria viewCriteria = vo.createViewCriteria();
            ViewCriteriaRow viewCriteriaRow = viewCriteria.createViewCriteriaRow();
            viewCriteriaRow.setAttribute("Username", username);
            viewCriteria.add(viewCriteriaRow);
            viewCriteria.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
            vo.applyViewCriteria(viewCriteria);
            vo.executeQuery();
            while(vo.hasNext()){
               row = (LoginUsersViewRowImpl)vo.next();
               row.setAttribute("PassWord", newPassword);
            }
            vo.getDBTransaction().commit();
            vo.executeQuery();
            isPasswordChanged = true;
        }catch(Exception exception){
            System.err.println("Error changing password in changePassword() method");
          //  exception.printStackTrace();
        }finally{
            if(appMod != null){
                Configuration.releaseRootApplicationModule(appMod, false);                      
            }
        }
        return isPasswordChanged;
    } 
    
    public boolean isOldPasswordRight(String oldPassword, String username){
        boolean isOldPasswordRight = false;
        ApplicationModule appMod=null;
        LoginUsersViewImpl vo;
        LoginUsersViewRowImpl row;
      //  String username = "";
        try{
            username = UsersViewImpl.getLoggedInUsername();
            System.err.println(username);
            appMod = Configuration.createRootApplicationModule("fleet.model.AppModule", "AppModuleFleetLocal");
            vo = (LoginUsersViewImpl)appMod.findViewObject("LoginUsersView1");
            ViewCriteria viewCriteria = vo.createViewCriteria();
            ViewCriteriaRow viewCriteriaRow = viewCriteria.createViewCriteriaRow();
            viewCriteriaRow.setAttribute("PassWord", oldPassword);
            viewCriteriaRow.setAttribute("Username", username);
            viewCriteria.add(viewCriteriaRow);
            viewCriteria.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
            vo.applyViewCriteria(viewCriteria);
            vo.executeQuery();
            while(vo.hasNext()){                          
                isOldPasswordRight = true;
                break;
            }
            vo.getDBTransaction().commit();
            vo.executeQuery();           
        }catch(Exception exception){
            System.err.println("Error changing password in changePassword() method");
          //  exception.printStackTrace();
        }finally{
            if(appMod != null){
                Configuration.releaseRootApplicationModule(appMod, false);                      
            }
        }
        return isOldPasswordRight;
    }     
    
    private boolean getUserPassword(String username, String oldPassword){
        boolean isPasswordChanged = false;
        ApplicationModule appMod=null; 
        LoginUsersViewImpl vo;
        LoginUsersViewRowImpl row;
        String password = "";
        try{
            appMod = Configuration.createRootApplicationModule("fleet.model.AppModule", "AppModuleFleetLocal");
            vo = (LoginUsersViewImpl)appMod.findViewObject("LoginUsersView1");
            ViewCriteria viewCriteria = vo.createViewCriteria();
            ViewCriteriaRow viewCriteriaRow = viewCriteria.createViewCriteriaRow();
            viewCriteriaRow.setAttribute("Username", username);
            viewCriteria.add(viewCriteriaRow);
            viewCriteria.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
            vo.applyViewCriteria(viewCriteria);
            vo.executeQuery();
            while(vo.hasNext()){
               row = (LoginUsersViewRowImpl)vo.next();
               password = row.getAttribute("PassWord") != null ? row.getAttribute("PassWord").toString() : "";
            }
            vo.getDBTransaction().commit();
            vo.executeQuery();
        }catch(Exception exception){
            System.err.println("Error changing password in changePassword() method");
            exception.printStackTrace();
        }finally{
            if(appMod != null){
                Configuration.releaseRootApplicationModule(appMod, false);                      
            }
        }
        return isPasswordChanged;
    }        
}

