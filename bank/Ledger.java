import java.util.ArrayList;
import java.util.Random;

public class Ledger {
    private ArrayList<bankAccount> ledger;

    public Ledger(){
        this.ledger = new ArrayList<bankAccount>();
    }

    public void addAccount(String name, int savings){
        Random rand = new Random();
        ledger.add(new bankAccount(name, rand.nextInt(90000)+10000,savings));
    }

    public void removeAccount(int accountNumber){
        for(int i = 0; i < ledger.size(); i++){
            if(ledger.get(i).getAccountNumber() == accountNumber){
                ledger.remove(i);
            }
        }
    }

    public void sortByName(){
        for(int i = 0; i < ledger.size()-1; i++){
            for(int j = 0; j < ledger.size()-1; j++){
                if(ledger.get(j).getName().compareTo(ledger.get(j+1).getName())>0){
                    bankAccount temp = ledger.get(j+1);
                    ledger.set(j+1,ledger.get(j));
                    ledger.set(j, temp);
                }
            }
        }
    }

    public void sortByAccountNumber(){
        for(int i = 0; i < ledger.size()-1; i++){
            for(int j = 0; j < ledger.size()-1; j++){
                if(ledger.get(j).getAccountNumber() > ledger.get(j+1).getAccountNumber()){
                    bankAccount temp = new bankAccount(ledger.get(j+1).getName(),ledger.get(j+1).getAccountNumber(),ledger.get(j+1).getSavings());
                    ledger.set(j+1,ledger.get(j));
                    ledger.set(j, temp);
                }
            }
        }
    }

    public void sortBySavings(){
        for(int i = 0; i < ledger.size()-1; i++){
            for(int j = 0; j < ledger.size()-1; j++){
                if(ledger.get(j).getSavings() > ledger.get(j+1).getSavings()){
                    bankAccount temp = new bankAccount(ledger.get(j+1).getName(),ledger.get(j+1).getAccountNumber(),ledger.get(j+1).getSavings());
                    ledger.set(j+1,ledger.get(j));
                    ledger.set(j, temp);
                }
            }
        }
    }

    public bankAccount searchByName(String name){
        sortByName();
        int low = 0;
        int high = ledger.size() - 1;
        int mid = (low + high) / 2;
        while(low != high){
            if(name.compareToIgnoreCase(ledger.get(mid).getName()) == 0){
                return ledger.get(mid);
            }
            if(name.compareToIgnoreCase(ledger.get(mid).getName()) > 0){
                low = mid + 1;
            }
            if(name.compareToIgnoreCase(ledger.get(mid).getName()) < 0){
               high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return null;
    }

    public int total(){
        int total = 0;
        for(int i = 0; i < ledger.size(); i++){
            total += ledger.get(i).getSavings();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ledger{" +
                "ledger=" + ledger +
                '}';
    }
}
