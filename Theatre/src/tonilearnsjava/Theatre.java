package tonilearnsjava;

import java.util.SortedSet;
import java.util.TreeSet;

public class Theatre {
    private String name;
    private int seatsInRow;
    private final SortedSet<Seat> seats = new TreeSet<>();

    static class Seat implements Comparable<Seat>{
        private char row;
        private int number;

        private String seatNumber;

        private boolean isReserved;

        public Seat(char row, int number, boolean isReserved) {
            this.row = row;
            this.number = number;
            this.isReserved = isReserved;
            seatNumber = getSeatNumber();
        }

        public void setReserved(boolean reserved) {
            isReserved = reserved;
        }

        private String getSeatNumber(){
            if(this.number > 999) return  null;
            return String.valueOf(row) + (number / 100) + ((number / 10) % 10)+ (number % 10);
        }


        @Override
        public int compareTo(Seat o) {
            return this.seatNumber.compareTo(o.seatNumber);
        }

        @Override
        public String toString() {
            return seatNumber;
        }
    }

    public Theatre(String name, int seatsInRow, int numSeats) {
        this.name = name;
        this.seatsInRow = seatsInRow;
        int numOfRows = numSeats/seatsInRow;
        for(int i = 0; i < numOfRows; i ++){
            var row = (char)(i+65);
            for (int j = 0; j < seatsInRow; j ++){
                seats.add(new Seat(row, j, false));
            }
        }
    }

    public void printSeatMap(int numRows){
        for(int i= 0; i < numRows; i ++){
            var subset = seats.subSet(new Seat((char)(i+65),0,false),new Seat((char)(i+65),11,false));
            subset.forEach(s->System.out.print(s+ " "));
            System.out.println();
        }
    }

}
