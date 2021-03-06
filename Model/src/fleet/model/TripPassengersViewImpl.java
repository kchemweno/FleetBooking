package fleet.model;

//import com.oracle.igf.config.util.Configuration;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.client.Configuration;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time. 
// ---    Wed Sep 13 14:52:49 EAT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TripPassengersViewImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public TripPassengersViewImpl() {
    }
  
   public boolean isUserOnTrip(int bookingId, int bookingForUserId){
        boolean isUserOnTrip = false;
        ApplicationModule appMod=null;
        AppModuleFleetImpl appM;
        TripPassengersViewImpl vo;
        UsersViewImpl usersViewImpl;// = new UsersViewImpl();
        TripPassengersViewRowImpl row;
        int loggedInUser = 0;
        int bookedUserId = 0;
        int onTripFlag = 0;
        try{            
            appMod = Configuration.createRootApplicationModule("fleet.model.AppModuleFleet","AppModuleFleetShared");
            vo = (TripPassengersViewImpl)appMod.findViewObject("TripPassengersView1");     
            ViewCriteria viewCriteria = vo.createViewCriteria();            
            ViewCriteriaRow viewCriteriaRow = viewCriteria.createViewCriteriaRow();
            viewCriteriaRow.setAttribute("BookingId", bookingId);
            viewCriteria.add(viewCriteriaRow);
            viewCriteria.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
            vo.applyViewCriteria(viewCriteria);
            vo.executeQuery();
           // usersViewImpl = new UsersViewImpl();
           // int x=0;
            while(vo.hasNext()){
                row = (TripPassengersViewRowImpl)vo.next();
                bookedUserId = row.getAttribute("UserId") != null ? Integer.parseInt(row.getAttribute("UserId").toString()) : 0;
                onTripFlag = row.getAttribute("OnTrip") != null ? Integer.parseInt(row.getAttribute("OnTrip").toString()) : 0;
                loggedInUser = UsersViewImpl.loggedinUserId;             
            if((bookedUserId == loggedInUser) && onTripFlag == 1) {
                    isUserOnTrip = true;                    
                } 
                bookedUserId = 0;
            }
        }catch(Exception exception){
            System.err.println("Error finding if user is on trip");
            exception.printStackTrace();
        }finally{
            if(appMod != null){
                Configuration.releaseRootApplicationModule(appMod, false);                      
            }
            vo = null;
         //usersViewImpl = null;
        }
        return isUserOnTrip;
    } 
  
    public boolean joinTrip(int bookingId){
        boolean joinStatus = false;
        ApplicationModule appMod=null;
        TripPassengersViewImpl vo;           
        int userId = 0;
        try{
            appMod = Configuration.createRootApplicationModule("fleet.model.AppModuleFleet","AppModuleFleetLocal");
            vo = (TripPassengersViewImpl)appMod.findViewObject("TripPassengersView1");          
           //userId = UsersViewImpl.getLoggedinUserId();
            Row row = vo.createRow();
            row.setAttribute("BookingId", bookingId);
            row.setAttribute("UserId", UsersViewImpl.loggedinUserId);
            vo.executeQuery();
            vo.getDBTransaction().commit();
            vo.executeQuery();
            joinStatus = true;        
        }catch(Exception exception){
            System.err.println("Error joining trip in joinTrip()");
            joinStatus = false;
            //exception.printStackTrace();
        }finally{
            if(appMod != null){
                Configuration.releaseRootApplicationModule(appMod, false);                      
            }            
            vo = null;
        }
        return joinStatus;
    }  
    
    public boolean leaveTrip(int bookingId, int userId){
        boolean success = false;
        ApplicationModule appMod=null;
        TripPassengersViewImpl vo;           
       // int userId = 0;
        try{
            appMod = Configuration.createRootApplicationModule("fleet.model.AppModuleFleet","AppModuleFleetLocal");
            vo = (TripPassengersViewImpl)appMod.findViewObject("TripPassengersView1");          
            userId = UsersViewImpl.getLoggedinUserId();
            ViewCriteria viewCriteria = vo.createViewCriteria();
            ViewCriteriaRow viewCriteriaRow = viewCriteria.createViewCriteriaRow();
            viewCriteriaRow.setAttribute("BookingId", bookingId);
            viewCriteriaRow.setAttribute("UserId", userId);
            viewCriteria.add(viewCriteriaRow);
            viewCriteria.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
            vo.applyViewCriteria(viewCriteria);
            vo.executeQuery();
            while(vo.hasNext()){
                TripPassengersViewRowImpl row = (TripPassengersViewRowImpl)vo.next();
                row.setAttribute("OnTrip", 0);
            }          
            vo.getDBTransaction().commit();
            vo.executeQuery();
            success = true;        
        }catch(Exception exception){
            System.err.println("Error leaving trip in leaveTrip() method");
            success = false;
            //exception.printStackTrace();
        }finally{
            if(appMod != null){
                Configuration.releaseRootApplicationModule(appMod, false);                      
            }            
            vo = null;
        }
        return success;
    }  
       
   /* public boolean insertTripPassenger(){
        boolean success = false;
        try{
           AppM
        }catch(Exception exception){
            System.err.println("Error inserting trip passenger in insertTripPassenger method");
            exception.printStackTrace();
        }
        return success;
    } */

    /**
     * Returns the variable value for bookingIdBindVariable.
     * @return variable value for bookingIdBindVariable
     */
    public Integer getbookingIdBindVariable() {
        return (Integer) ensureVariableManager().getVariableValue("bookingIdBindVariable");
    }

    /**
     * Sets <code>value</code> for variable bookingIdBindVariable.
     * @param value value to bind as bookingIdBindVariable
     */
    public void setbookingIdBindVariable(Integer value) {
        ensureVariableManager().setVariableValue("bookingIdBindVariable", value);
    }

    /**
     * Returns the variable value for userIdBindVariable.
     * @return variable value for userIdBindVariable
     */
    public Integer getuserIdBindVariable() {
        return (Integer) ensureVariableManager().getVariableValue("userIdBindVariable");
    }

    /**
     * Sets <code>value</code> for variable userIdBindVariable.
     * @param value value to bind as userIdBindVariable
     */
    public void setuserIdBindVariable(Integer value) {
        ensureVariableManager().setVariableValue("userIdBindVariable", value);
    }
}