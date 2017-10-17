package fleet.model;

import oracle.jbo.RowIterator;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jun 08 13:25:41 EAT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmailPropertiesViewRowImpl extends ViewRowImpl {
    public static final int ENTITY_EMAILPROPERTIES = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        Id,
        EmailBookingAlertSubject,
        EmailBookingAlertBody,
        EmailBookingApprovedSubject,
        EmailBookingApprovedBody,
        EmailBookingNotApprovedSubject,
        EmailBookingNotApprovedBody,
        IsActive,
        Comments,
        TripsView,
        TripsView1,
        TripsView2,
        RefillsView,
        BookingsView,
        BookingsView1,
        BookingsView2,
        BookingsView3,
        UsersView,
        UsersView1;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int ID = AttributesEnum.Id.index();
    public static final int EMAILBOOKINGALERTSUBJECT = AttributesEnum.EmailBookingAlertSubject.index();
    public static final int EMAILBOOKINGALERTBODY = AttributesEnum.EmailBookingAlertBody.index();
    public static final int EMAILBOOKINGAPPROVEDSUBJECT = AttributesEnum.EmailBookingApprovedSubject.index();
    public static final int EMAILBOOKINGAPPROVEDBODY = AttributesEnum.EmailBookingApprovedBody.index();
    public static final int EMAILBOOKINGNOTAPPROVEDSUBJECT = AttributesEnum.EmailBookingNotApprovedSubject.index();
    public static final int EMAILBOOKINGNOTAPPROVEDBODY = AttributesEnum.EmailBookingNotApprovedBody.index();
    public static final int ISACTIVE = AttributesEnum.IsActive.index();
    public static final int COMMENTS = AttributesEnum.Comments.index();
    public static final int TRIPSVIEW = AttributesEnum.TripsView.index();
    public static final int TRIPSVIEW1 = AttributesEnum.TripsView1.index();
    public static final int TRIPSVIEW2 = AttributesEnum.TripsView2.index();
    public static final int REFILLSVIEW = AttributesEnum.RefillsView.index();
    public static final int BOOKINGSVIEW = AttributesEnum.BookingsView.index();
    public static final int BOOKINGSVIEW1 = AttributesEnum.BookingsView1.index();
    public static final int BOOKINGSVIEW2 = AttributesEnum.BookingsView2.index();
    public static final int BOOKINGSVIEW3 = AttributesEnum.BookingsView3.index();
    public static final int USERSVIEW = AttributesEnum.UsersView.index();
    public static final int USERSVIEW1 = AttributesEnum.UsersView1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EmailPropertiesViewRowImpl() {
    }

    /**
     * Gets EmailProperties entity object.
     * @return the EmailProperties
     */
    public EntityImpl getEmailProperties() {
        return (EntityImpl) getEntity(ENTITY_EMAILPROPERTIES);
    }

    /**
     * Gets the attribute value for id using the alias name Id.
     * @return the id
     */
    public Integer getId() {
        return (Integer) getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as attribute value for id using the alias name Id.
     * @param value value to set the id
     */
    public void setId(Integer value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for email_booking_alert_subject using the alias name EmailBookingAlertSubject.
     * @return the email_booking_alert_subject
     */
    public String getEmailBookingAlertSubject() {
        return (String) getAttributeInternal(EMAILBOOKINGALERTSUBJECT);
    }

    /**
     * Sets <code>value</code> as attribute value for email_booking_alert_subject using the alias name EmailBookingAlertSubject.
     * @param value value to set the email_booking_alert_subject
     */
    public void setEmailBookingAlertSubject(String value) {
        setAttributeInternal(EMAILBOOKINGALERTSUBJECT, value);
    }

    /**
     * Gets the attribute value for email_booking_alert_body using the alias name EmailBookingAlertBody.
     * @return the email_booking_alert_body
     */
    public String getEmailBookingAlertBody() {
        return (String) getAttributeInternal(EMAILBOOKINGALERTBODY);
    }

    /**
     * Sets <code>value</code> as attribute value for email_booking_alert_body using the alias name EmailBookingAlertBody.
     * @param value value to set the email_booking_alert_body
     */
    public void setEmailBookingAlertBody(String value) {
        setAttributeInternal(EMAILBOOKINGALERTBODY, value);
    }

    /**
     * Gets the attribute value for email_booking_approved_subject using the alias name EmailBookingApprovedSubject.
     * @return the email_booking_approved_subject
     */
    public String getEmailBookingApprovedSubject() {
        return (String) getAttributeInternal(EMAILBOOKINGAPPROVEDSUBJECT);
    }

    /**
     * Sets <code>value</code> as attribute value for email_booking_approved_subject using the alias name EmailBookingApprovedSubject.
     * @param value value to set the email_booking_approved_subject
     */
    public void setEmailBookingApprovedSubject(String value) {
        setAttributeInternal(EMAILBOOKINGAPPROVEDSUBJECT, value);
    }

    /**
     * Gets the attribute value for email_booking_approved_body using the alias name EmailBookingApprovedBody.
     * @return the email_booking_approved_body
     */
    public String getEmailBookingApprovedBody() {
        return (String) getAttributeInternal(EMAILBOOKINGAPPROVEDBODY);
    }

    /**
     * Sets <code>value</code> as attribute value for email_booking_approved_body using the alias name EmailBookingApprovedBody.
     * @param value value to set the email_booking_approved_body
     */
    public void setEmailBookingApprovedBody(String value) {
        setAttributeInternal(EMAILBOOKINGAPPROVEDBODY, value);
    }

    /**
     * Gets the attribute value for email_booking_not_approved_subject using the alias name EmailBookingNotApprovedSubject.
     * @return the email_booking_not_approved_subject
     */
    public String getEmailBookingNotApprovedSubject() {
        return (String) getAttributeInternal(EMAILBOOKINGNOTAPPROVEDSUBJECT);
    }

    /**
     * Sets <code>value</code> as attribute value for email_booking_not_approved_subject using the alias name EmailBookingNotApprovedSubject.
     * @param value value to set the email_booking_not_approved_subject
     */
    public void setEmailBookingNotApprovedSubject(String value) {
        setAttributeInternal(EMAILBOOKINGNOTAPPROVEDSUBJECT, value);
    }

    /**
     * Gets the attribute value for email_booking_not_approved_body using the alias name EmailBookingNotApprovedBody.
     * @return the email_booking_not_approved_body
     */
    public String getEmailBookingNotApprovedBody() {
        return (String) getAttributeInternal(EMAILBOOKINGNOTAPPROVEDBODY);
    }

    /**
     * Sets <code>value</code> as attribute value for email_booking_not_approved_body using the alias name EmailBookingNotApprovedBody.
     * @param value value to set the email_booking_not_approved_body
     */
    public void setEmailBookingNotApprovedBody(String value) {
        setAttributeInternal(EMAILBOOKINGNOTAPPROVEDBODY, value);
    }

    /**
     * Gets the attribute value for is_active using the alias name IsActive.
     * @return the is_active
     */
    public Integer getIsActive() {
        return (Integer) getAttributeInternal(ISACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for is_active using the alias name IsActive.
     * @param value value to set the is_active
     */
    public void setIsActive(Integer value) {
        setAttributeInternal(ISACTIVE, value);
    }

    /**
     * Gets the attribute value for comments using the alias name Comments.
     * @return the comments
     */
    public String getComments() {
        return (String) getAttributeInternal(COMMENTS);
    }

    /**
     * Sets <code>value</code> as attribute value for comments using the alias name Comments.
     * @param value value to set the comments
     */
    public void setComments(String value) {
        setAttributeInternal(COMMENTS, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link TripsView.
     */
    public RowIterator getTripsView() {
        return (RowIterator) getAttributeInternal(TRIPSVIEW);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link TripsView1.
     */
    public RowIterator getTripsView1() {
        return (RowIterator) getAttributeInternal(TRIPSVIEW1);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link TripsView2.
     */
    public RowIterator getTripsView2() {
        return (RowIterator) getAttributeInternal(TRIPSVIEW2);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link RefillsView.
     */
    public RowIterator getRefillsView() {
        return (RowIterator) getAttributeInternal(REFILLSVIEW);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link BookingsView.
     */
    public RowIterator getBookingsView() {
        return (RowIterator) getAttributeInternal(BOOKINGSVIEW);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link BookingsView1.
     */
    public RowIterator getBookingsView1() {
        return (RowIterator) getAttributeInternal(BOOKINGSVIEW1);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link BookingsView2.
     */
    public RowIterator getBookingsView2() {
        return (RowIterator) getAttributeInternal(BOOKINGSVIEW2);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link BookingsView3.
     */
    public RowIterator getBookingsView3() {
        return (RowIterator) getAttributeInternal(BOOKINGSVIEW3);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link UsersView.
     */
    public RowIterator getUsersView() {
        return (RowIterator) getAttributeInternal(USERSVIEW);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link UsersView1.
     */
    public RowIterator getUsersView1() {
        return (RowIterator) getAttributeInternal(USERSVIEW1);
    }
}
