package fleet.view.backing;

import fleet.model.AppModuleFleetImpl;
import fleet.model.BookingsViewImpl;
import fleet.model.EmailPropertiesViewImpl;
import fleet.model.UsersViewImpl;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

public class Create_new_booking {
    private RichPanelFormLayout pfl1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichInputDate id1;
    private RichInputText it1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichInputText it2;
    private RichInputDate id2;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichButton b1;
    private RichSpacer s1;
    private RichButton b2;
    private RichSpacer s3;
    private RichSpacer s2;
    private BookingsViewImpl bookingsViewImpl;
    private UsersViewImpl usersViewImpl;    

    private int bookingId;    
    private String bookersComments;
    private String bookingTitle;
    private String bookingBy;
    private Date travelTime;
    private Date tripEndTime;
    private String destination;
    private String itemsToTransport;
    private int itemsToTransportId;
    private String bookingStatus;
    private String bookingType;
    private int bookingTypeId;
    
    private int bookingForUserId;    
    
    private static String emailTo;
    private static String emailCc;
    private static String emailSubject;
    private static String emailBody;
    private static String userId;    

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi2(UISelectItems si2) {
        this.si2 = si2;
    }

    public UISelectItems getSi2() {
        return si2;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }


    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setPgl1(RichPanelGridLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGridLayout getPgl1() {
        return pgl1;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
    }


    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }


    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }


    public String insertNewBooking(){
        boolean success = false;
        AppModuleFleetImpl appModule;
        try{
        bookingsViewImpl = new BookingsViewImpl();
        usersViewImpl = new UsersViewImpl(); 
            //Replace with currentlyloggedinuserid
        int userId =  usersViewImpl.getUserId(ADFContext.getCurrent().getSecurityContext().getUserName());
           // UsersViewImpl.getLoggedinUserId();
        int bookingId = bookingsViewImpl.createBooking(userId, getBookingForUserId(), getBookingTypeId() , 
                                      getItemsToTransportId(), getTravelTime(), getTripEndTime(), 
                                      getDestination(), getBookersComments());
            appModule = new AppModuleFleetImpl();
            success = appModule.insertTripPassenger(bookingId, userId);
            if(success){     
            sendBookingConfirmationEmail();
            showMessageSuccess("New booking successful. Wait for communication from Logistics supervisor");       
        }else{
            showMessageFailure("Booking not successful. Please try again");
        }
        }catch(Exception exception){
            System.err.println("Error inserting new booking in insertNewBooking() method");
            exception.printStackTrace();
        }finally{
          // closePopup(); //======
        }
        return "";
    }
    
    public void sendBookingConfirmationEmail(){
        EmailPropertiesViewImpl emailPropertiesViewImpl;
        try{
        emailPropertiesViewImpl = new EmailPropertiesViewImpl();
        usersViewImpl = new UsersViewImpl();          
        //userId = "1";     //Get logged in user's userId variable value
        String username = ADFContext.getCurrent().getSecurityContext().getUserName();        
        userId = usersViewImpl.getUserId(username) + "";
        String userFullname = usersViewImpl.getUserFullname(userId);
        //userId = get
        emailTo = usersViewImpl.getEmail(userId);
        System.err.println("UserId at sendBookingConfirmationEmail() : "+userId);
        //emailCc = "so-logistics@fao.org";
        //emailCc = "kiprotich.chemweno@fao.org";//For testing purposes, use previous line for production
        emailCc = "faofleetbooking@gmail.com";
        emailSubject = emailPropertiesViewImpl.getBookingAlertSubject();
        emailBody = emailPropertiesViewImpl.getBookingAlertBody();
        emailBody = emailBody.replace("USER", userFullname);            
        SendEmail.send(emailTo, emailCc, emailSubject, emailBody);
        }catch(Exception exception){
            System.err.println("Error sending booking confirmation email"); 
            exception.printStackTrace();
        }finally{
            emailPropertiesViewImpl = null;
        }
    }    
    
    public void showMessageSuccess(String messageToShow) {
        FacesMessage message = new FacesMessage(messageToShow);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, message);
    }
    
    public void showMessageFailure(String messageToShow) {
        FacesMessage message = new FacesMessage(messageToShow);
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, message);
    }

    public void setBookersComments(String bookersComments) {
        this.bookersComments = bookersComments;
    }

    public String getBookersComments() {
        bookersComments = it2.getValue() != null ? it2.getValue().toString() : "";
        return bookersComments;
    }

    public void setItemsToTransportId(int itemsToTransportId) {
        this.itemsToTransportId = itemsToTransportId;
    }

    public int getItemsToTransportId() {
        itemsToTransportId = soc1.getValue() != null ? Integer.parseInt(soc1.getValue().toString()) : 0;
        return itemsToTransportId;
    }

    public void setBookingForUserId(int bookingForUserId) {
        this.bookingForUserId = bookingForUserId;
    }

    public int getBookingForUserId() {
        int bookingForUserId =  soc3.getValue() !=null ? Integer.parseInt(soc3.getValue().toString()) : 0 ;
        return bookingForUserId;
    }

    public void setBookingTypeId(int bookingTypeId) {
        this.bookingTypeId = bookingTypeId;
    }

    public int getBookingTypeId() {
        bookingTypeId = soc2.getValue() !=null ? Integer.parseInt(soc2.getValue().toString()) : 0 ;
        return bookingTypeId;
    }        

    public void setBookingTitle(String bookingTitle) {
        this.bookingTitle = bookingTitle;
    }

    public String getBookingTitle() {
        return bookingTitle;
    }

    public void setBookingBy(String bookingBy) {
        this.bookingBy = bookingBy;
    }

    public String getBookingBy() {
        return bookingBy;
    }

    public void setTravelTime(Date travelTime) {
        this.travelTime = travelTime;
    }

    public Date getTravelTime() { //Travel time
       // DefaultDateFormatter dateFormat = new DefaultDateFormatter();
        //dateFormat.format("yyyy-MM-dd hh:mm", new java.util.Date(id5.getValue()) : null;
       // travelTime = id5.getValue() != null ? new java.sql.Date(id5.getValue()) : null;
        
        return travelTime;
    }

    public void setTripEndTime(Date tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public Date getTripEndTime() {
       // tripEndTime = id2.getValue() != null ? new java.util.Date((Long)id2.getValue()) : null;
        return tripEndTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        if(it1 != null){
        destination = it1.getValue() != null ? it1.getValue().toString() : "";
        }else{
        //    System.err.println("it1 is null");
        }
        return destination;
    }

    public void setItemsToTransport(String itemsToTransport) {
        this.itemsToTransport = itemsToTransport;
    }

    public String getItemsToTransport() {
        return itemsToTransport;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getBookingType() {
        return bookingType;
    }
}
