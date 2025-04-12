package entities;

public class StringCol implements Column{
    int id;
    int minLength;
    int maxLength;
    String defaultValue;
    @Override
    public boolean verifyConstraint(Object s) {
        String ss=(String)s;
        if(ss.length()<minLength||ss.length()>maxLength)
            return false;
        else return true;
    }
    public StringCol(){
        defaultValue="";
    }
    public StringCol(int min,int max,String def){
        minLength=min;
        maxLength=max;
        defaultValue=def;
    }
}
