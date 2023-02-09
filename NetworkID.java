public class NetworkID {
    
    public String getNetworkAddress(String ip, int hosts) {
        Table t = new Table();
        String[] vals = ip.split("[.]");
        int last = Integer.parseInt(vals[vals.length - 1]);
        last = last + Integer.parseInt(t.getHosts(hosts));
        vals[vals.length -1] = Integer.toString(last);
        ip = String.join(".", vals);
        return ip;
    }
}
