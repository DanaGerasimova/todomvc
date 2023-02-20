package how.autotest.helpers;

public class XDsl {
    private String selector;
    public XDsl(){
        selector = "";
    }
    public XDsl all(){
        selector += "//*";
        return this;
    }
    public String path() {
        System.out.println(selector);
        return selector;
    }
    public XDsl descendant(String value){
        selector += "//" + value;
        return this;
    }

    public XDsl id(String value){
        selector += "[@id='" + value + "']";
        return this;
    }

    public XDsl descendantWithText(String value){
        selector += "[.//text()='" + value + "']";
        return this;
    }

    public XDsl cssClassContains(String value){
        selector += "[contains(concat(' ',@class,' '),' " + value + " ')]";
        return this;
    }
    public XDsl cssClassNotContains(String value){
        selector += "[not(contains(concat(' ',@class,' '),' " + value + " '))]";
        return this;
    }
}
