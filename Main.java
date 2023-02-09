import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
// Bka Ako toh

public class Main {
    public static void main(String[] args) {
        // All objects used
        NetworkID nets = new NetworkID();
        UsableHosts hosts = new UsableHosts();
        Formatter fmt = new Formatter();
        Scanner network = new Scanner(System.in);
        SubnetMask sMask = new SubnetMask();
        Iprange iRange = new Iprange();
        BroadcastId bCastId = new BroadcastId();

        // Network and no. of subnets needed
        System.out.print("\nNetwork to be subnetted        : ");
        String net = network.nextLine();
        System.out.print("No. of subnets needed          : ");
        int subnets = network.nextInt();

        // Customizing subnet names
        ArrayList<String> networkNames = new ArrayList<String>();
        ArrayList<Integer> usableHosts = new ArrayList<Integer>();

        // Loop to get all required names and number of hosts
        for (int i = 0; i < subnets; i++) {
            System.out.print("Enter name for subnet " + (i + 1) + "        : ");
            String name = network.next();
            networkNames.add(name);
            System.out.print("Enter no. of Hosts for subnet " + (i + 1) + ": ");
            int noHosts = network.nextInt();
            usableHosts.add(noHosts);
        }

        // Setting up the Storage for the gathered values

        // Storage for all gathered Network Addresses
        ArrayList<String> networksAddresses = new ArrayList<>();
        ArrayList<String> broadcastAddresses = new ArrayList<>();
        ArrayList<String> subnetMaskAddresses = new ArrayList<>();
        ArrayList<Integer> noUsableHosts = new ArrayList<>();
        ArrayList<String> firstUsables = new ArrayList<>();
        ArrayList<String> lastUsables = new ArrayList<>();

        
        // Initial variable values
        String networksAll = net.split("/")[0];
        String broadcast = "";
        String subnetmaskAdd = "";
        int useHost = 0;
        String firstUsable = "";
        String lastUsable = "";


        // Main loop for gathering all values and appending to ArrayLists
        for (int i = 0;i<subnets;i++){
            if (i == 0) {
                networksAddresses.add(networksAll);
            } else {
                networksAll = nets.getNetworkAddress(networksAll, usableHosts.get(i-1));
                networksAddresses.add(networksAll);
            }
            broadcast = bCastId.broadcastGet(networksAll, usableHosts.get(i));
            broadcastAddresses.add(broadcast);
            subnetmaskAdd = sMask.snetMask(usableHosts.get(i));
            subnetMaskAddresses.add(subnetmaskAdd);
            useHost = hosts.noUsableHosts(usableHosts.get(i));
            noUsableHosts.add(useHost);
            firstUsable = iRange.getFirst(networksAll);
            firstUsables.add(firstUsable);
            lastUsable = iRange.getLast(networksAll, usableHosts.get(i));
            lastUsables.add(lastUsable);

        }

        System.out.println();
        fmt.format("%15s%22s%16s%24s%20s%16s%23s","Subnets", "Network Address", "Subnet Mask", "First Usable Host","Last Usable Host","Usable Hosts","Broadcast Addr.\n");
        for (int i=0;i<networksAddresses.size();i++){
            fmt.format("%14s%21s%20s%19s%21s%13s%25s\n",networkNames.get(i),networksAddresses.get(i), subnetMaskAddresses.get(i), firstUsables.get(i), lastUsables.get(i), noUsableHosts.get(i),broadcastAddresses.get(i));
        }
        System.out.println(fmt);
        // Network address *
        // Subnet mask by /
        // First usable address
        // Last usable address
        // Number of usable hosts
        // Subnet Mask Address *
        // Broadcast Address *
        // PRINT USING FORMATTER IN JAVA
        network.close();

    }
}
