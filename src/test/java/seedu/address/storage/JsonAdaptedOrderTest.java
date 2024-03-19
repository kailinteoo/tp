package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedOrder.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalOrders.ROSES;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.order.Amount;
import seedu.address.model.order.Deadline;
import seedu.address.model.order.OrderDate;
import seedu.address.model.order.OrderId;
import seedu.address.model.order.Remark;
import seedu.address.model.order.Status;

public class JsonAdaptedOrderTest {

    private static final String INVALID_ORDERID = "#FXXXXXXXX";
    private static final String INVALID_ORDERDATE = "24/D/23";
    private static final String INVALID_DEADLINE = "24/D/23";
    private static final String INVALID_AMOUNT = "@6.7";
    private static final String INVALID_REMARK = "%HOME";
    private static final String INVALID_STATUS = "#NOW";
    private static final String VALID_ORDERID = "1";
    private static final String VALID_ORDERDATE = "2024-03-19";
    private static final String VALID_DEADLINE = "2024-03-21";
    private static final String VALID_AMOUNT = "50.00";
    private static final String VALID_REMARK = "Urgent order";
    private static final String VALID_STATUS = "Pending";

    @Test
    public void toModelType_validOrderDetails_returnsOrder() throws Exception {
        JsonAdaptedOrder order = new JsonAdaptedOrder(ROSES);
        assertEquals(ROSES, order.toModelType());
    }

    @Test
    public void toModelType_invalidOrderId_throwsIllegalValueException() {
        JsonAdaptedOrder order =
                new JsonAdaptedOrder(INVALID_ORDERID, VALID_ORDERDATE, VALID_DEADLINE, VALID_AMOUNT,
                        VALID_REMARK, VALID_STATUS);
        String expectedMessage = OrderId.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullOrderId_throwsIllegalValueException() {
        JsonAdaptedOrder order =
                new JsonAdaptedOrder(null, VALID_ORDERDATE, VALID_DEADLINE, VALID_AMOUNT,
                        VALID_REMARK, VALID_STATUS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, OrderId.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullOrderDate_throwsIllegalValueException() {
        JsonAdaptedOrder order =
                new JsonAdaptedOrder(VALID_ORDERID, null, VALID_DEADLINE, VALID_AMOUNT,
                        VALID_REMARK, VALID_STATUS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, OrderDate.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullDeadline_throwsIllegalValueException() {
        JsonAdaptedOrder order =
                new JsonAdaptedOrder(VALID_ORDERID, VALID_ORDERDATE, null, VALID_AMOUNT,
                        VALID_REMARK, VALID_STATUS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Deadline.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullAmount_throwsIllegalValueException() {
        JsonAdaptedOrder order =
                new JsonAdaptedOrder(VALID_ORDERID, VALID_ORDERDATE, VALID_DEADLINE, null,
                        VALID_REMARK, VALID_STATUS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Amount.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullRemark_throwsIllegalValueException() {
        JsonAdaptedOrder order =
                new JsonAdaptedOrder(VALID_ORDERID, VALID_ORDERDATE, VALID_DEADLINE, VALID_AMOUNT,
                        null, VALID_STATUS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Remark.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }

    @Test
    public void toModelType_nullStatus_throwsIllegalValueException() {
        JsonAdaptedOrder order =
                new JsonAdaptedOrder(VALID_ORDERID, VALID_ORDERDATE, VALID_DEADLINE, VALID_AMOUNT,
                        VALID_REMARK, null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Status.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, order::toModelType);
    }
}

