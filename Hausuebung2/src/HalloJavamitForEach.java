import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HalloJavamitForEach {
    public void javamitForEach()
    {
        List<String> list = new ArrayList<>();
        list.add("Hallo");
        list.add("Hallo2");
        list.add("Hallo3");

        for (String s: list)
        {
            System.out.println(s);
        }

        list.forEach((String s) -> System.out.println(s));
        Consumer<String> consumer = (String s) -> System.out.println(s);
        list.forEach(consumer);
        list.forEach(System.out::print);
    }
}
