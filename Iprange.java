public class Iprange {

    public String getFirst(String ipFirst) {
        String[] arr = ipFirst.split("[.]");
        int firstUsable = Integer.parseInt(arr[arr.length-1]); // 128
        int finalFirst = firstUsable + 1; // 129
        arr[arr.length-1] = Integer.toString(finalFirst);
        ipFirst = String.join(".", arr);
        return ipFirst; 
    }

    public String getLast(String ipLast, int hosts) {
        Table tab = new Table();
        String[] arr = ipLast.split("[.]");
        int lastUsable = Integer.parseInt(arr[arr.length-1]);
        lastUsable = Integer.parseInt(tab.getHosts(hosts)) + lastUsable; 
        int finalLast = lastUsable - 2;
        arr[arr.length-1] = Integer.toString(finalLast);
        ipLast = String.join(".", arr);
        return ipLast;
    }
}