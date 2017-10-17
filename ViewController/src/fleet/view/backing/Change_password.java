package fleet.view.backing;

import fleet.model.LoginUsersViewImpl;

import fleet.model.UsersViewImpl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;

public class Change_password {
    private RichPageTemplate pt1;
    private RichForm f1;
    private RichDocument d1;
    private RichMessages m1;
    private RichPanelFormLayout pfl1;
    private RichPanelGridLayout pgl1;
    private RichGridCell gc1;
    private RichPanelGridLayout pgl2;
    private RichGridRow gr2;
    private RichGridCell gc2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichGridRow gr3;
    private RichGridCell gc5;
    private RichGridCell gc6;
    private RichGridCell gc7;
    private RichGridRow gr4;
    private RichGridCell gc8;
    private RichGridCell gc10;
    private RichGridRow gr5;
    private RichGridCell gc11;
    private RichButton b2;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }

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

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }


    public void setPgl1(RichPanelGridLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGridLayout getPgl1() {
        return pgl1;
    }


    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public String changePassword() {
        LoginUsersViewImpl loginUsersViewImpl = new LoginUsersViewImpl();
        boolean isPasswordChanged = false;
        try {
            String username = "";
            String newPassword = "";
            String newPasswordRepeated = "";
            String oldPassword = "";
            oldPassword = it1.getValue() != null ? it1.getValue().toString() : "";
            newPassword = it2.getValue() != null ? it2.getValue().toString() : "";
            newPasswordRepeated = it3.getValue() != null ? it3.getValue().toString() : "";            
           if (newPassword.equals(newPasswordRepeated)) {
                //Check if old password is right
                if(loginUsersViewImpl.isOldPasswordRight(oldPassword, username)){
                isPasswordChanged = loginUsersViewImpl.changePassword(oldPassword, newPassword);
                if (isPasswordChanged) {
                    showMessageChangePasswordSuccess();
                } else {
                    showMessageChangePasswordFailure();                  
                }
                }else{
                    showMessageWarning("Your current password is incorrect. Please try again");
                }
            } else {
                showMessageWarning("New password and repeat password do not match, please try again");
            }
        } catch (Exception exception) {
            System.err.println("Error changing password in changePassword() method");
        }finally{
           // clearChangePasswordForm();
        }
        return "";
    }
    
    private void clearChangePasswordForm(){
       // it1.resetValue();
       // it2.setValue("");
       // it3.setValue("");          
    }

    public void showMessageChangePasswordSuccess() {
        FacesMessage Message = new FacesMessage("Password changed successfully");
        Message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
    }

    public void showMessageChangePasswordFailure() {
        FacesMessage Message = new FacesMessage("Password not changed. Please try again");
        Message.setSeverity(FacesMessage.SEVERITY_FATAL);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
    }

    public void showMessageWarning(String message) {
        FacesMessage Message = new FacesMessage(message);
        Message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, Message);
    }

    public void setPgl2(RichPanelGridLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGridLayout getPgl2() {
        return pgl2;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichGridCell getGc6() {
        return gc6;
    }

    public void setGc7(RichGridCell gc7) {
        this.gc7 = gc7;
    }

    public RichGridCell getGc7() {
        return gc7;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGc8(RichGridCell gc8) {
        this.gc8 = gc8;
    }

    public RichGridCell getGc8() {
        return gc8;
    }


    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
    }

    public RichGridCell getGc10() {
        return gc10;
    }


    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGc11(RichGridCell gc11) {
        this.gc11 = gc11;
    }

    public RichGridCell getGc11() {
        return gc11;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
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

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }  
}
