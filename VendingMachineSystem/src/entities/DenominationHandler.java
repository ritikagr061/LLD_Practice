package entities;

import java.util.*;

public class DenominationHandler {
    List<Denomination> denominations;
    public DenominationHandler(){
        denominations = new ArrayList<>(List.of(
                //new Denomination(1,10),
                new Denomination(2,10),
                new Denomination(5,10),
                new Denomination(10,10),
                new Denomination(20,10),
                new Denomination(50,10)));
        Collections.sort(denominations, new Comparator<Denomination>() {
            @Override
            public int compare(Denomination o1, Denomination o2) {
                return o2.getValue()-o1.getValue();
            }
        });
    }

    public List<Integer> isTransactionPossible(String notes, int productPrice){
        List<String> cash = new ArrayList<>(List.of(notes.split(",")));
        int total=0;
        for(String c:cash){
            total+=Integer.valueOf(c);
        }
        int toReturn = total - productPrice;
        List<Integer> notesToBeReturned = new ArrayList<>();
        if(toReturn<0)
            return null;
        else{
            for (Denomination d : denominations) {
                int used = 0;
                while (toReturn >= d.getValue() && used < d.getQuantity()) {
                    toReturn -= d.getValue();
                    notesToBeReturned.add(d.getValue());
                    used++;
                }
            }
            return toReturn == 0 ? notesToBeReturned : null;
        }
    }


    public void completePayment(String notes,List<Integer> notesToBeReturned){
        List<String> cash = new ArrayList<>(List.of(notes.split(",")));
        for(String c:cash){
            int value=Integer.valueOf(c);
            Denomination d=denominations.stream().filter(den->den.getValue()==value).findFirst().get();
            d.setQuantity(d.getQuantity()+1);
        }
        for(int note:notesToBeReturned){
            Denomination d=denominations.stream().filter(den->den.getValue()==note).findFirst().get();
            d.setQuantity(d.getQuantity()-1);
        }
        System.out.println("Returned denominations are: "+notesToBeReturned);
    }
}
