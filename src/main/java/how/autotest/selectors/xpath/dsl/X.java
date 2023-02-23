package how.autotest.selectors.xpath.dsl;

public class X {
    private String selector;
    private X(String value){
        selector = value;
    }
    public X descendant(String value){
        selector += "//" + value;
        return this;
    }
    public static X all(){
        return new X("//*");
    }
    public X by(String value){
        selector += "[" + value + "]";
        return this;
    }
    public X byNot(String value){
        return this.by(Its.not(value));
    }
    public String path() {
        return selector;
    }
}
