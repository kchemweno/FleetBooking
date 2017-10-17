package fleet.view.backing;

import fleet.model.EmailPropertiesViewImpl;
import fleet.model.UsersViewImpl;

import java.util.List;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;

public class Process_bookings {
    private RichPageTemplate pt1;
    private RichForm f1;
    private RichDocument d1;
    private RichPanelCollection pc1;
    private RichMessages m1;
    private RichToolbar t2;
    private RichButton b1;
    private RichButton b2;
    private RichSpacer s1;
    private static String bookingStatus;
    private RichTable t1;
    private RichInputDate id1;
    private RichInputDate id3;
    private RichInputDate id5;

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

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }


    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }


    //Email to alert user of their booking's approval or disapproval
    public void sendBookingApprovalDisapprovalEmail() {
      /*  EmailPropertiesViewImpl emailPropertiesViewImpl = new EmailPropertiesViewImpl();
        UsersViewImpl usersViewImpl = new UsersViewImpl();
        //SendEmail sendEmail = new SendEmail();
        String userId = "1"; //Get logged in user's userId variable value
        //userId = get
        String emailTo = usersViewImpl.getEmail(userId);
        //emailCc = "so-logistics@fao.org";
        //emailCc = "kiprotich.chemweno@fao.org";//For testing purposes, use previous line for production
        String emailCc = "chemweno@gmail.com";
        String emailSubject = emailPropertiesViewImpl.getBookingApprovedSubject();
        String emailBody = emailPropertiesViewImpl.getBookingApprovedBody();
        SendEmail.send(emailTo, emailCc, emailSubject, emailBody); */
    }

    public void processBookingsTableSelectionListener(SelectionEvent selectionEvent) {
        //Get table from selectionEvent
        //RichTable richTable = (RichTable) selectionEvent.getSource();
        //Cast to the List that populates table
        //Process_bookings row = (Process_bookings) richTable.getSelectedRowData();
        //List row = (List)richTable.getSelectedRowData();
        //Update booking status
        // Process_bookings.bookingStatus = row.get(9).toString();
        //System.out.println("Row 8 : "+row.get(8).toString());
        //System.out.println("Booking Status: "+bookingStatus);
        //System.out.println("Row 10 : "+row.get(10).toString());
    }


    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setId5(RichInputDate id5) {
        this.id5 = id5;
    }

    public RichInputDate getId5() {
        return id5;
    }
}
