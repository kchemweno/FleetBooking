package fleet.view.backing;

import fleet.model.AppModuleFleetImpl;
import fleet.model.BookingsViewImpl;
import fleet.model.EmailPropertiesViewImpl;
import fleet.model.TripPassengersViewImpl;
import fleet.model.UsersViewImpl;
import java.time.DayOfWeek;
import java.util.Calendar;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichNoteWindow;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichCalendar;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.dnd.DnDAction;
import oracle.adf.view.rich.event.CalendarActivityDurationChangeEvent;
import oracle.adf.view.rich.event.CalendarActivityEvent;
import oracle.adf.view.rich.event.CalendarEvent;
import oracle.adf.view.rich.event.DropEvent;
import oracle.adf.view.rich.model.CalendarActivity;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.component.UISelectItems;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichPanelWindow;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.datatransfer.DataFlavor;
import oracle.adf.view.rich.datatransfer.Transferable;
import oracle.adf.view.rich.dnd.CalendarDropSite;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.jbo.format.DefaultDateFormatter;

public class Bookings {
    private RichPageTemplate pt1;
    private RichForm f1;
    private RichDocument d1;
    private RichPanelCollection pc1;
    private RichToolbar t1;
    private RichButton b1;
    private RichSpacer s1;
    private RichButton b3;
    private RichSpacer s2;
    private RichMessages m1;
    private RichTable t2;
    private RichInputDate id1;
    private RichPanelTabbed pt2;
    private RichShowDetailItem calendarView;
    private RichShowDetailItem tableView;
    private RichCalendar c11; //userId
    //private RichOutputText ot2x;
    //private RichOutputText lblBooking;  //destination
    //transportItems
    private RichPanelStretchLayout psl1;
    private RichPopup p3;
    private RichNoteWindow nw2;
    private RichOutputText ot3;
    private RichOutputText ot7;
    private RichPanelFormLayout pfl3;
    private CalendarActivity activity; // = event.getCalendarActivity();
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
    private RichOutputText ot1;
    private CalendarEvent calendarEvent;
    private RichPopup p1;
    private RichRegion r1;
    private int bookingForUserId;
    //private UsersViewImpl usersViewImpl = new UsersViewImpl();
    //private EmailPropertiesViewImpl emailPropertiesViewImpl = new EmailPropertiesViewImpl();
    private RichPanelWindow pw1;
    private static String emailTo;
    private static String emailCc;
    private static String emailSubject;
    private static String emailBody;
    private static String userId;
    private RichOutputText ot2;
    private RichButton b4;
    private RichButton b5;
    private RichOutputText ot4;
    private BookingsViewImpl bookingsViewImpl;
    private UsersViewImpl usersViewImpl;
    private RichPopup p2;
    private RichPanelWindow pw2;
    private RichPanelFormLayout pfl1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichInputDate id5;
    private RichInputDate id2;
    private RichInputText it1;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichInputText it2;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
   // private RichSpacer s2;
    private RichSpacer s3;
    private RichSpacer s4;
    private RichSpacer s7;
   // private RichButton b2;
    private RichButton b8;
    private RichButton b9;
    private RichSpacer s8;
    private RichButton b2;
    private RichSpacer s9;
    private TripPassengersViewImpl tripPassengersViewImpl;
    private static int currentBookingId;
    private RichPanelFormLayout pfl2;
    private static Date travelDate = null;
    private RichRegion r2;

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

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
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


    public void setB3(RichButton b3) {
        this.b3 = b3;
    }

    public RichButton getB3() {
        return b3;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichSpacer getS2() {
        return s2;
    }


    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void enableTableColumns() {

    }

    public void setPt2(RichPanelTabbed pt2) {
        this.pt2 = pt2;
    }

    public RichPanelTabbed getPt2() {
        return pt2;
    }

    public void setCalendarView(RichShowDetailItem calendarView) {
        this.calendarView = calendarView;
    }

    public RichShowDetailItem getCalendarView() {
        return calendarView;
    }

    public void setTableView(RichShowDetailItem tableView) {
        this.tableView = tableView;
    }

    public RichShowDetailItem getTableView() {
        return tableView;
    }

    public void setC11(RichCalendar c11) {
        this.c11 = c11;
    }

    public RichCalendar getC11() {
        return c11;
    }

    public void calendarEventListener(CalendarEvent event) {
        java.util.Date date = null;
        try{
        System.err.println("Picked date "+event.getTriggerDate()+" updated on travel time component");
      // date = java.sql.Date.valueOf(event.getTriggerDate().getTime());
      date = event.getTriggerDate();
            
       //====================     
        id5.setValue(date);
        id2.setValue(date);            
       //====================                
            
        //Update new values not entered explicitly by user    
            
        }catch(Exception exception){
            exception.printStackTrace();
        }finally{
            System.err.println("Picked date clone "+event.getTriggerDate().clone() +" updated on travel time component");
        }
    }

    public void calendarActivityListener(CalendarActivityEvent event) {
        //CalendarActivity activity = event.getCalendarActivity();
        UsersViewImpl usersViewImpl = new UsersViewImpl();
        activity = event.getCalendarActivity();
        if (activity == null) {
            System.out.println("No activity with event: " + event);
            return;
        } else {
            AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
            //Update activity properties
            setBookingTitle(activity.getTitle()); //Title
            String userFullname = "";
            userId = activity.getProvider().getId();
            userFullname = usersViewImpl.getUserFullname(activity.getProvider().getId());
            setBookingBy(userFullname);
            setTravelTime(activity.getStartDate(c11.getTimeZone()));
            setDestination(activity.getLocation());
            //Update calendar activity 
            bookingId = Integer.parseInt(activity.getId().toString());
            setBookingId(bookingId); // Important
            currentBookingId = bookingId;//currentBookingId will be used when joining trip
            setBookingForUserId(Integer.parseInt(userId));
        }
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

    //For listening to drags of end time to increase or reduce end time of activities
    public void calendarActivityDurationChangeEventListener(CalendarActivityDurationChangeEvent event) {
        return;
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void setNw2(RichNoteWindow nw2) {
        this.nw2 = nw2;
    }

    public RichNoteWindow getNw2() {
        return nw2;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }


    public void setOt7(RichOutputText ot7) {
        this.ot7 = ot7;
    }

    public RichOutputText getOt7() {
        return ot7;
    }

    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    private void handleCalendarActivityDrop(DropEvent dropEvent, Date dropSiteDate, CalendarActivity activity,
                                            boolean showPopup) {
        activity.setStartDate(dropSiteDate, c11.getTimeZone());
        // activity.setEndDate(dropSiteDate + activity.getDuration(), arg1);

    }

    //Listen to activity drops
    public DnDAction calendarDropListener(DropEvent dropEvent) {
        Transferable transferable = dropEvent.getTransferable();
        CalendarDropSite dropSite = (CalendarDropSite) dropEvent.getDropSite();
        Date dropSiteDate = dropSite.getDate();
        CalendarActivity.TimeType timeType = dropSite.getTimeType();
        CalendarActivity activity = (CalendarActivity) transferable.getData(DataFlavor.getDataFlavor(CalendarActivity.class));
        //Move calendar activity within the same view
        if (activity != null) {
            // _handleCalendarActivityDrop(dropEvent, dropSiteDate, activity, false);
            handleCalendarActivityDrop(dropEvent, dropSiteDate, activity, false);
        }
        //  return DnDAction.MOVE;
        return dropEvent.getProposedAction();
    }

    private void _handleCalendarActivityDrop(DropEvent dropEvent, Date dropSiteDate, CalendarActivity activity, boolean showPopup) {
        TimeZone tz = c11.getTimeZone();
        Date startDate = activity.getStartDate(tz);
        Calendar startCal = Calendar.getInstance(tz);
        startCal.setTime(startDate);
        Calendar dropCal = Calendar.getInstance(tz);
        dropCal.setTime(dropSiteDate);
        int startDayOfYear = startCal.get(Calendar.DAY_OF_YEAR);
        int startHour = startCal.get(Calendar.HOUR_OF_DAY);
        int startMin = startCal.get(Calendar.MINUTE);
        int dropDayOfYear = dropCal.get(Calendar.DAY_OF_YEAR);
        int dropHour = dropCal.get(Calendar.HOUR_OF_DAY);
        int dropMin = dropCal.get(Calendar.MINUTE);

        // move the start date to the new time
        if (startDayOfYear != dropDayOfYear) {
            startCal.set(Calendar.DAY_OF_YEAR, dropDayOfYear);
            startCal.set(Calendar.YEAR, dropCal.get(Calendar.YEAR));
            startCal.set(Calendar.MONTH, dropCal.get(Calendar.MONTH));
        }

        // move this activity to the new location
        //if(demoActivity.isAllDayOrDuration())
        //  if(activity.isAllDayOrDuration())
        if (true) {
            //    {
            /*
        _proposedStartDate = startCal.getTime();
        // Get the original start day
        DayOfWeek startDay = demoActivity.getStartDay();

        // Calcuate new end day by using the new start day and the original delta
        Day endDay = demoActivity.getEndDay();
        Calendar endCal = Calendar.getInstance(tz);

        startCal = Calendar.getInstance(tz);
        endDay.updateCalendar(endCal);
        startDay.updateCalendar(startCal);

        long delta = endCal.getTime().getTime() -  startCal.getTime().getTime();
        Date endDate = new Date(_proposedStartDate.getTime() + delta);
      */
        } else {
            String view = ((RichCalendar) dropEvent.getDropComponent()).getView();
            if ((RichCalendar.VIEW_DAY.equals(view) || RichCalendar.VIEW_WEEK.equals(view)) && CalendarActivity.TimeType.TIME.equals(activity.getTimeType())) {
                if (startHour != dropHour)
                    startCal.set(Calendar.HOUR_OF_DAY, dropHour);
                if (dropMin != startMin) {
                    if (dropMin == 0 && startMin >= 30)
                        startCal.add(Calendar.MINUTE, -30);
                    else if (dropMin == 30 && startMin < 30)
                        startCal.add(Calendar.MINUTE, 30);
                }
            }

            // Date endDate = demoActivity.getEnd();
            Date endDate = activity.getEndDate(tz);
            long delta = endDate.getTime() - startDate.getTime();

            startDate = startCal.getTime();
            endDate = new Date(startDate.getTime() + delta);

            /*  if(showPopup && CalendarActivity.Recurring.RECURRING.equals(demoActivity.getRecurring()))
      {
        _proposedStartDate = startDate;
        _proposedEndDate = endDate;
        _addOpenPopupScript(FacesContext.getCurrentInstance(),
                            "dmoTpl:moveActivityPopup", null);
      }
      else*/
            // {
            // demoActivity.setStart(startDate);
            // demoActivity.setEnd(endDate);
            activity.setStartDate(startDate, tz);
            activity.setEndDate(endDate, tz);
        }
    }

    public void createPopupListener(PopupFetchEvent event) {

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

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void setPw1(RichPanelWindow pw1) {
        this.pw1 = pw1;
    }

    public RichPanelWindow getPw1() {
        return pw1;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void bookingForValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //Set Value for userId
        
    }

    public void setB4(RichButton b4) {
        this.b4 = b4;
    }

    public RichButton getB4() {
        return b4;
    }

    public void setB5(RichButton b5) {
        this.b5 = b5;
    }

    public RichButton getB5() {
        return b5;
    }

    public void setOt4(RichOutputText ot4) {
        this.ot4 = ot4;
    }

    public RichOutputText getOt4() {
        return ot4;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void joinTrip(){
     //   AppModuleFleetImpl appModule = new AppModuleFleetImpl();
        tripPassengersViewImpl = new TripPassengersViewImpl();
        try{
         //   int bookingId = 1;
         //   if(appModule.joinTrip(bookingId)){
          
         if(tripPassengersViewImpl.joinTrip(currentBookingId)){
                showMessageSuccess("You've successfully joined trip");
            }else{
                showMessageFailure("Joining trip failed. Please try again");
            }
        }catch(Exception exception){
            System.err.println("Error joining trip");
        }finally{
          //  appModule = null;
        }
    }

    public boolean leaveTrip() {
        boolean success = false;
       // AppModuleFleetImpl appModule = new AppModuleFleetImpl();
        tripPassengersViewImpl = new TripPassengersViewImpl();
        try{
          //  int user = Integer.parseInt(userId);
          //  if(appModule.leaveTrip(bookingId, user)){
          if(tripPassengersViewImpl.leaveTrip(bookingId, UsersViewImpl.loggedinUserId)){
                showMessageSuccess("You've successfully left trip");
                }else{
                showMessageFailure("Leaving trip failed. Please try again");
                }
        }catch(Exception exception){
            System.err.println("Error leaving trip in leaveTrip() method");
            exception.printStackTrace();
        }
        return success;
    }
    
    public boolean isUserOnTrip(){
      TripPassengersViewImpl tripPassengers = new TripPassengersViewImpl();
      boolean onTrip = tripPassengers.isUserOnTrip(bookingId, bookingForUserId);
      return  onTrip;
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
        itemsToTransportId = soc3.getValue() != null ? Integer.parseInt(soc3.getValue().toString()) : 0;
        return itemsToTransportId;
    }

    public void setBookingForUserId(int bookingForUserId) {
        this.bookingForUserId = bookingForUserId;
    }

    public int getBookingForUserId() {
        int bookingForUserId =  soc1.getValue() !=null ? Integer.parseInt(soc1.getValue().toString()) : 0 ;
        return bookingForUserId;
    }

    public void setBookingTypeId(int bookingTypeId) {
        this.bookingTypeId = bookingTypeId;
    }

    public int getBookingTypeId() {
        bookingTypeId = soc2.getValue() !=null ? Integer.parseInt(soc2.getValue().toString()) : 0 ;
        return bookingTypeId;
    }

    public void insertNewBooking(){
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
        }finally{
           closePopup(); 
        }
      //  return success;
    }
    
    public void closePopup(){
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        p2.hide();
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void setPw2(RichPanelWindow pw2) {
        this.pw2 = pw2;
    }

    public RichPanelWindow getPw2() {
        return pw2;
    }

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

    public void setId5(RichInputDate id5) {
        this.id5 = id5;
    }

    public RichInputDate getId5() {
        return id5;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
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


    public void setS3(RichSpacer s3) {
        this.s3 = s3;
    }

    public RichSpacer getS3() {
        return s3;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setS7(RichSpacer s7) {
        this.s7 = s7;
    }

    public RichSpacer getS7() {
        return s7;
    }

    public void setB8(RichButton b8) {
        this.b8 = b8;
    }

    public RichButton getB8() {
        return b8;
    }

    public void setB9(RichButton b9) {
        this.b9 = b9;
    }

    public RichButton getB9() {
        return b9;
    }

    public void setS8(RichSpacer s8) {
        this.s8 = s8;
    }

    public RichSpacer getS8() {
        return s8;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setS9(RichSpacer s9) {
        this.s9 = s9;
    }

    public RichSpacer getS9() {
        return s9;
    }

    public void travelTimeValueChangeListener(ValueChangeEvent valueChangeEvent) {
        travelTime = (java.util.Date)valueChangeEvent.getNewValue();      
    }

    public void tripEndTimeValueChangeListener(ValueChangeEvent valueChangeEvent) {
        tripEndTime = (java.util.Date)valueChangeEvent.getNewValue();
    }

    public void destinationValueChangeListener(ValueChangeEvent valueChangeEvent) {
        destination = (String)valueChangeEvent.getNewValue();
      //  System.err.println("Destination is : "+destination);
    }


  /*  public void bookingDetailsPopupFetchListener(PopupFetchEvent popupFetchEvent) {
   //    b4.setVisible();
   //    b4.setVisible();
        if(isUserOnTrip()){
            if(b4 != null || b5 != null){
                b4.setVisible(false);
                b5.setVisible(true);
               }
        }else{
            if(b4 != null || b5 != null){
            b4.setVisible(true);
            b5.setVisible(false);
            }
        }
    } */

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void newBookingPopupFetchListener(PopupFetchEvent popupFetchEvent) {
       // travelDate = date;
        if(travelDate == null){
            System.err.println("travelDate is NULL"); 
        }else{
            System.err.println("travelDate is not null"); 
        }
        //System.out.println(travelDate.clone());
        if(id5 == null){
           System.err.println("id5 is NULL"); 
        }else{
        id5.setValue(travelDate);       
        }
    }


    public void setR2(RichRegion r2) {
        this.r2 = r2;
    }

    public RichRegion getR2() {
        return r2;
    }
}
