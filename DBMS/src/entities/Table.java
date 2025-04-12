package entities;

import java.util.*;

public class Table {
    Column primaryKey;
    Map<Cell,Row> rows;  // primaryKeyCell , Row
    List<Column> schema;
    String tableName;
    //for simplicity purpose removed list of indexs, could add later
    Map<Cell,List<Cell>> index;  //index cell, list of primary keys

    public Table(String tableName,List<Column> schema,Column pk){
        //make pk as first column
        //todo
        this.schema=schema;
        this.primaryKey=pk;
        rows=new TreeMap<>();
        this.tableName=tableName;
        index= new TreeMap<>();
    }

    public void addIndex(Column indexCol){
        for(Cell pk: rows.keySet()){

            //first get column against indexcolumn
            Cell indexCell=null;

            for( Cell c: rows.get(pk).values){
                if(c.columnDetails==indexCol){
                    indexCell=c;
                    break;
                }
            }

            if(index.containsKey(indexCell)){
                ArrayList<Cell> temp=index.get(indexCell);

            }
            else{
                index.put(indexCell,new ArrayList<Cell>(Arrays.asList(pk)));
            }
            index.put(indexCell,)
        }
    }
    public void addRow(List<Cell> cells){
        //assuming primary key is first column;
        Cell pk=cells.get(0);
        rows.put(pk,new Row(cells.size(),cells));
    }
    public void deleteRow(Cell primaryKeyVal){
        rows.remove(primaryKeyVal);
    }

    public void updateRow(Cell pk,List<Cell> cells){
        deleteRow(pk);
        addRow(cells);
    }



}
