package how.autotest.selectors.xpath.dsl;

public class Its {
    public static String id(String value){
        return "@id='" + value + "'";
    }
    public static String descendantWithText(String value){
        return ".//text()='" + value + "'";
    }
    public static String cssClassContains(String value){
        return "contains(concat(' ',@class,' '),' " + value + " ')";
    }
    public static String not(String value){
        return "not(" + value + ")";
    }
}
