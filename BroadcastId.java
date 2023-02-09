public class BroadcastId {
    
    public String broadcastGet(String ip, int hosts) {
        //192.168.1.0
        Table t = new Table();
        String[] values = ip.split("[.]"); // 192 168 1 0
        int last = Integer.parseInt(values[values.length - 1]); // 0
        int host = Integer.parseInt(t.getHosts(hosts)) - 1; // "127"
        last = last + host;
        String s = Integer.toString(last);
        values[values.length - 1] = s;
        ip = String.join(".", values);
        return ip;
    }

}
