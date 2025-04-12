package entities;

public class Cell {
    public Column columnDetails;
    public Object value;

    public Cell(Object o){
        if(!columnDetails.verifyConstraint(o))
            System.out.println("Invalid value, constraint breach");
        else
            value=o;
    }
}
