package fleet.model.common;

import java.sql.Timestamp;

import oracle.jbo.Row;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Sep 19 13:26:42 EAT 2017
// ---------------------------------------------------------------------
public interface BookingsViewRow extends Row {
    Integer getId();

    void setId(Integer value);

    Integer getUserId();

    void setUserId(Integer value);

    Integer getBookingTypeId();

    void setBookingTypeId(Integer value);

    Timestamp getBookingTime();

    void setBookingTime(Timestamp value);

    Timestamp getExpectedTravelTime();

    void setExpectedTravelTime(Timestamp value);

    String getDestination();

    void setDestination(String value);

    Integer getBookingForUserId();

    void setBookingForUserId(Integer value);

    Integer getItemsTransportedId();

    void setItemsTransportedId(Integer value);

    String getBookingStaffComments();

    void setBookingStaffComments(String value);

    Timestamp getBookingActionTime();

    void setBookingActionTime(Timestamp value);

    String getApprovingStaffComments();

    void setApprovingStaffComments(String value);

    Integer getBookingStatusId();

    void setBookingStatusId(Integer value);

    Integer getIsActive();

    void setIsActive(Integer value);

    Timestamp getTripEndTime();

    void setTripEndTime(Timestamp value);

    String getProviderId();

    void setProviderId(String value);

    String getIdString();

    void setIdString(String value);

    String getRecurring();

    String getTimeType();

    String getAllDay();

    String getTimezone();

    Integer getAllocatedDriverId();

    void setAllocatedDriverId(Integer value);

    Integer getAllocatedVehicleId();

    void setAllocatedVehicleId(Integer value);
}

