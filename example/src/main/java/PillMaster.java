import com.tw.container.PillBox;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import static com.google.common.io.Resources.getResource;

public class PillMaster {
    public static void main(String[] arg) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, FileNotFoundException {
        final URL resource = getResource("application_context.yml");
        final PillBox pillBox = PillBox.loadContext(resource.getFile());
        System.out.println(pillBox.create_pill("a"));
        System.out.println(pillBox.create_pill("b"));
        System.out.println(pillBox.create_pill("c"));
    }
}
