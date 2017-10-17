package fleet.view.backing;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import fleet.model.UsersViewImpl;

import fleet.model.UsersViewRowImpl;


import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;

import oracle.adf.view.rich.component.rich.output.RichImage;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.client.Configuration;


public class Login {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichInputText it2;
    private RichButton b1;
    private RichPanelGridLayout pgl3;
    private RichGridRow gr4;
    private RichGridCell gc10;    
    private UsersViewImpl usersViewImpl;
    //private static int userId;
    private int userId;
    public static int loggedInUserId;
    private String _username;
    private String _password;
    private RichOutputText ot2;
    private RichPanelStretchLayout psl1;
    private RichPanelGroupLayout pgl2;
    private RichPanelGroupLayout pgl4;
    private RichPanelGroupLayout pgl5;
    private RichImage i1;
    private RichOutputText ot1;


    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }
    
    private boolean isUserMatched(String username, String password){
        boolean isUserMatched = false;
        usersViewImpl = new UsersViewImpl();  
        ApplicationModule appMod=null;
        UsersViewImpl vo;
        String pass = "";
        try{
         appMod = Configuration.createRootApplicationModule("fleet.model.AppModule", "AppModuleFleetLocal");
         vo = (UsersViewImpl) appMod.findViewObject("UsersView1");
        //Create View criteria
        ViewCriteria viewCriteria = vo.createViewCriteria();
        ViewCriteriaRow viewCriteriaRow = viewCriteria.createViewCriteriaRow();
        viewCriteriaRow.setAttribute("Username", username);
        viewCriteria.add(viewCriteriaRow);
        viewCriteria.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
        vo.applyViewCriteria(viewCriteria);
        vo.executeQuery();
      // int userId = 0;        
        while (vo.hasNext()) {
            UsersViewRowImpl row = (UsersViewRowImpl) vo.next();
           // userId = row.getId();
           pass = row.getPassWord();
        } 
        
        isUserMatched = password.equals(pass);
        }catch(Exception exception){
            exception.printStackTrace();
            }finally{
                if(appMod != null){
                    Configuration.releaseRootApplicationModule(appMod, false);                      
                }
               vo = null;
            }
        return  isUserMatched;
    }

    public boolean login(){
        boolean isLoggedIn = false;
        FacesContext ctx = FacesContext.getCurrentInstance();
        String username = it1.getValue().toString();
        String password = it2.getValue().toString();
        if (username == null || password == null) {
            showError("Invalid credentials", "An incorrect username or password was specified.", null);
        } else {
            ExternalContext ectx = ctx.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
            try {
               // request.login(_username, _password); // Servlet 3.0 login
                isLoggedIn = isUserMatched(username, password);
                if(isLoggedIn){
                //On successful logic, update value of global userId
                usersViewImpl = new UsersViewImpl();                
                //Login.setUserId(usersViewImpl.getUserId(_username));
                setUserId(usersViewImpl.getUserId(username));    //THIS LINE TAKE A VEEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRYYYYYYYYYYYYYY LONG TIME TO EXECUTE
                UsersViewImpl.setLoggedinUserId(userId);
                //userId = usersViewImpl.getUserId(_username);
              //  System.out.println("UserId : " + userId);
                _username = null;
                _password = null;
                    username = null;
                    password = null;                
                String loginUrl = ectx.getRequestContextPath() + "/adfAuthentication?success_url=/faces/bookings.jsf";
                redirect(loginUrl);
                }else{
                    showError("ServletException", "Login failed. Incorrect username and/or password combination.", null);  
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                showError("ServletException", "Login failed. Please verify the username and password and try again.", null);
            }
        }               
        return isLoggedIn;
    }

    public String doLogin() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        //_username = getUsername();
        //_password = getPassword();
        _username = it1.getValue().toString();
        _password = it2.getValue().toString();
        if (_username == null || _password == null) {
            showError("Invalid credentials", "An incorrect username or password was specified.", null);
        } else {
            ExternalContext ectx = ctx.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
            try {
                request.login(_username, _password); // Servlet 3.0 login
                //On successful logic, update value of global userId
                usersViewImpl = new UsersViewImpl();                
                //Login.setUserId(usersViewImpl.getUserId(_username));
                setUserId(usersViewImpl.getUserId(_username));    //THIS LINE TAKE A VEEEEEEEEEEEEEEEERRRRRRRRRRRRRRRRRRRRRYYYYYYYYYYYYYY LONG TIME TO EXECUTE
                UsersViewImpl.setLoggedinUserId(userId);
                //userId = usersViewImpl.getUserId(_username);
                System.out.println("UserId : " + userId);
                _username = null;
                _password = null;
                String loginUrl = ectx.getRequestContextPath() + "/adfAuthentication?success_url=/faces/bookings.jsf";
                redirect(loginUrl);
            } catch (ServletException fle) {
                showError("ServletException", "Login failed. Please verify the username and password and try again.", null);
            }
        }
        return null;
    }

    private void redirect(String forwardUrl) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = ctx.getExternalContext();
        try {
            ectx.redirect(forwardUrl);
        } catch (IOException ie) {
            showError("IOException", "An error occurred during redirecting. Please consult logs for more information.",
                      ie);
        }
    }

    private void showError(String errType, String message, Exception e) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, errType, message);
        FacesContext.getCurrentInstance().addMessage("d2:it35", msg);
        if (e != null) {
            e.printStackTrace();
        }
    }

    public String logoff() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext ectx = ctx.getExternalContext();
        HttpServletRequest httpRequest = (HttpServletRequest) ectx.getRequest();
        try {
            httpRequest.logout(); // Servlet 3.0 logout
            HttpSession session = httpRequest.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            String logoutUrl = ectx.getRequestContextPath() + "/faces" + ctx.getViewRoot().getViewId();
            redirect(logoutUrl);
        } catch (ServletException e) {
            showError("ServletException", "An error occurred during logout. Please consult logs for more information.",
                      e);
        }
        return null;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getUsername() {
        return _username;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getPassword() {
        return _password;
    }


    public void setPgl3(RichPanelGridLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGridLayout getPgl3() {
        return pgl3;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
    }

    public RichGridCell getGc10() {
        return gc10;
    }

  /*  public static void setUserId(int userId) {
        Login.userId = userId;
    }

    public static int getUserId() {
        return userId;
    }*/

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }


    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }

    public void setPgl5(RichPanelGroupLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGroupLayout getPgl5() {
        return pgl5;
    }

    public void setI1(RichImage i1) {
        this.i1 = i1;
    }

    public RichImage getI1() {
        return i1;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }
}
