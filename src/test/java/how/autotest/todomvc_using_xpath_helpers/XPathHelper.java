package how.autotest.todomvc_using_xpath_helpers;

public class XPathHelper {
    public static String containsClassName(String className){
        return "contains(concat(' ',@class,' '),' " + className + " ')";
    }

    public static String id(String idName){
        return "//*[@id='" + idName + "']";
    }

    public static String child(String childName){
        return "//" + childName;
    }
}
