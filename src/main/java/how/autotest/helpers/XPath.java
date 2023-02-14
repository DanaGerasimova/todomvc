package how.autotest.helpers;

public class XPath {
    public static String predicateCssClass(String value){
        return "contains(concat(' ',@class,' '),' " + value + " ')";
    }

    public static String id(String value){
        return "//*[@id='" + value + "']";
    }

    public static String descendant(String value){
        return "//" + value;
    }
}
