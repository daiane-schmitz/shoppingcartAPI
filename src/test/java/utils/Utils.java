package utils;

public class Utils {

    public static String getContractsBasePath(String pack, String json) {
        return System.getProperty("user.dir")
                + "/src/test/java/tests/"
                + pack
                + "/contract/"
                + json
                + ".json";
    }
}
