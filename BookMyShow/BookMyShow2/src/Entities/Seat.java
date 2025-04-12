package Entities;

import enums.Status;

public class Seat {
    Status status;
    int horizontalIndex;
    int verticalIndex;
    public Seat(int i,int j){
        horizontalIndex=i;
        verticalIndex=j;
        status=Status.empty;
    }
}
