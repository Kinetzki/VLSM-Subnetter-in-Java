public class UsableHosts {
    
    public int noUsableHosts(int hosts){
        Table t = new Table();
        hosts = Integer.parseInt(t.getHosts(hosts)) - 2;
        return hosts;
    }
}
