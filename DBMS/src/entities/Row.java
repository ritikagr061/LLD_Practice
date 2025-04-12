package entities;

import java.util.ArrayList;
import java.util.List;

public class Row {
    public List<Cell> values;
    public Row(int length){
        values=new ArrayList<>();

    }
    public Row(int length,List<Cell> vals){
        values=vals;
    }
}
