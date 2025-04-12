package entities;

public class IntColumn implements Column{
    int id;
    int minValue;
    int maxValue;
    int defaultValue;
    @Override
    public boolean verifyConstraint(Object o) {
        int x=(int)o;
        if(x<minValue||x>maxValue)
            return false;
        else return true;
    }
    public IntColumn(){
        defaultValue=0;
    }
    public IntColumn(int min,int max,int defaultValue){
        this.defaultValue=defaultValue;
        minValue=min;
        maxValue=max;
    }
}
