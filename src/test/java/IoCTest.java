import com.tw.container.PillBox;
import example.Aspirin;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class IoCTest {
    @Test
    public void should_create_pill() throws Exception {
        PillBox pillbox = PillBox.loadContext("application_context.xml");
        final Object aspirin = pillbox.create_pill("aspirin");
        assertThat(aspirin, notNullValue());
        assertThat((Aspirin)aspirin, notNullValue());
    }

}
