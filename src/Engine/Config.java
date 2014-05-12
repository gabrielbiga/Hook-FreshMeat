package Engine;

public class Config {
    private static String physicalPath;
    private static char pathDelim;

    public static String getPhysicalPath() {
        return physicalPath;
    }

    public static void setPhysicalPath(String physicalPath) {
        Config.physicalPath = physicalPath;
    }

    public static char getPathDelim() {
        return pathDelim;
    }

    public static void setPathDelim(char pathDelim) {
        Config.pathDelim = pathDelim;
    }
    
    
}
