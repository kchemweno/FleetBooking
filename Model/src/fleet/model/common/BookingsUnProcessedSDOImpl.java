package fleet.model.common;

import org.eclipse.persistence.sdo.SDODataObject;

@SuppressWarnings("serial")
public class BookingsUnProcessedSDOImpl extends fleet.model.common.BookingsViewSDOImpl implements BookingsUnProcessedSDO {

   public static final int START_PROPERTY_INDEX = fleet.model.common.BookingsViewSDOImpl.END_PROPERTY_INDEX;

   public static final int END_PROPERTY_INDEX = START_PROPERTY_INDEX + 0;

   public BookingsUnProcessedSDOImpl() {}


}

