import java.util.ArrayList;
import java.util.Arrays;

public class Table {

    // ArrayList<Integer> subnets = new ArrayList<>(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256));
    ArrayList<Integer> noHosts = new ArrayList<>(Arrays.asList(256, 128, 64, 32, 16, 8, 4, 2, 1));
    ArrayList<String> subnetMask = new ArrayList<>(Arrays.asList("/24", "/25", "/26", "/27", "/28", "/29", "/30", "/31", "/32"));
    ArrayList<Integer> subnetMaskId = new ArrayList<>(Arrays.asList(0, 128, 192, 224, 240, 248, 252, 254, 255));

    public String getHosts(int hosts) {
        String numHost = "";
        for (int i = noHosts.size()-1;i >= 0;i--){
            if (noHosts.get(i) >= hosts) {
                numHost = noHosts.get(i).toString();
                break;
            }
        }
        return numHost;
    }

    public String getSubnetMask(int hosts){
        String numHost = "";
        for (int i = noHosts.size()-1;i >= 0;i--){
            if (noHosts.get(i) >= hosts) {
                numHost = Integer.toString(subnetMaskId.get(i));
                break;
            }
        }
        return numHost;
    }

    public int getMask(int hosts) {
        return 0;
    }
}
