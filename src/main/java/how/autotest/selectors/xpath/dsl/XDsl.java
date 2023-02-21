package how.autotest.selectors.xpath.dsl;

public class XDsl {
    private String selector;
    public XDsl(){
        selector = "";
    }
    public XDsl descendant(String value){
        selector += "//" + value;
        return this;
    }
    public XDsl all(){
        return descendant("*");
    }
    public static XDsl returnObject(){
        return new XDsl();
    }
    public XDsl by(String value){
        selector += "[" + value + "]";
        return this;
    }
    public String path() {
        return selector;
    }
}
