import com.starsep.rrbridge_bidding_data.bidding.call.Call;
import com.starsep.rrbridge_bidding_data.bidding.call.CallFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CallFactoryTest {
    @Test
    public void testDigitZero() {
        String bid = "0D";
        Call call = CallFactory.create(bid);
        assertEquals("<td>INVALID(0D)</td>", call.html().toString());
    }

    @Test
    public void testDigitEight() {
        String bid = "8D";
        Call call = CallFactory.create(bid);
        assertEquals("<td>INVALID(8D)</td>", call.html().toString());
    }

    @Test
    public void testInvalidColor() {
        String bid = "2A";
        Call call = CallFactory.create(bid);
        assertEquals("<td>INVALID(2A)</td>", call.html().toString());
    }
}
