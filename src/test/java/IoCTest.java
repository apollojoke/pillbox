import com.tw.container.PillBox;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class IoCTest {
    @Test
    public void should_create_pill() throws Exception {
        assertThat(PillBox.create_pill("aspirin"), notNullValue());
    }
}
