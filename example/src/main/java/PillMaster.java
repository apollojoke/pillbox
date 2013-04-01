import com.tw.container.PillBox;
import milk.BabyMilk;
import milk.ManualMilk;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import static com.google.common.io.Resources.getResource;

public class PillMaster {
    public static void main(String[] arg) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, FileNotFoundException, NoSuchFieldException {
        final URL resource = getResource("application_context.yml");
        final PillBox pillBox = PillBox.loadContext(resource.getFile());
        System.out.println(pillBox.create_pill("a"));
        System.out.println(pillBox.create_pill("b"));
        System.out.println(pillBox.create_pill("c"));

        BabyMilk milk = (BabyMilk) pillBox.create_pill("milk");
        System.out.println(milk);
        System.out.println(milk.getFat());
        System.out.println(milk.getLinoleicAcid());
        System.out.println(milk.getProtein());
        ManualMilk milk2 = (ManualMilk) pillBox.create_pill("manual_milk");
        System.out.println(milk2);
        System.out.println(milk2);
        System.out.println(milk2.getFat());
        System.out.println(milk2.getLinoleicAcid());
        System.out.println(milk2.getProtein());
    }
}
