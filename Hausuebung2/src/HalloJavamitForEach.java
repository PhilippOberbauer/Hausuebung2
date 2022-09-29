import java.util.ArrayList;
import java.util.List;

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
    }
}
