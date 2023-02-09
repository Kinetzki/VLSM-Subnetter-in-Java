public class SubnetMask {
    
    public String snetMask(int hosts){
        Table t = new Table();
        String net = "255.255.255.";
        net = net + t.getSubnetMask(hosts);
        return net;
    }
}
