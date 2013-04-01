import com.tw.container.PillBox;
import example.Aspirin;
import example.Vitamin;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class IoCTest {

    private PillBox pillbox;

    @Before
    public void setUp() throws Exception {
        final URL resource = getClass().getResource("application_context.yml");
        pillbox = PillBox.loadContext(resource.getFile());
    }

    @Test
    public void should_create_pill() throws Exception {
        final Object aspirin = pillbox.create_pill("aspirin");
        assertThat(aspirin, notNullValue());
        assertThat((Aspirin)aspirin, notNullValue());
    }

    @Test
    public void should_create_by_pill_name() throws Exception {
        final Object pill = pillbox.create_pill("vitamin");
        assertThat(pill, notNullValue());
        assertThat((Vitamin)pill, notNullValue());
    }

    @Test
    public void should_create_pill_with_constructor_args() throws Exception {
        final URL resource = getClass().getResource("test_constructor_context.yml");
        pillbox = PillBox.loadContext(resource.getFile());
        final Object pill = pillbox.create_pill("milk");
        assertThat(pill, notNullValue());
    }

}
