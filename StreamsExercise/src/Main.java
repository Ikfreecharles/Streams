import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Clients c1 = new Clients("John", "Connor",10_000, false);
        Clients c2 = new Clients("T1000", "T1000",27_000, true);
        Clients c3 = new Clients("Sarah", "Connor",80_000, true);
        Clients c4 = new Clients("Marty", "McFly",146_000, false);
        Clients c5 = new Clients("Emmet", "Brown",12_000, true);
        Clients c6 = new Clients("Biff", "Tannen",500_000, true);

        Clients[] clients = {c1, c2, c3, c4, c5, c6};
        printLn(clients);

        //HomeWork. Print out the names in their natural order and capitalize the first letter of each name.
        List<String> names = Arrays.asList("Amelia","Olivia","emily","Isla","Ava","oliver","Jack","Charlie","harry","Jakob");
        names.stream().
                map((fCharacter) -> {
                    char firstWord = fCharacter.charAt(0);
                    String newWord = "";
                    String firstWordUpperCase = Character.toString(firstWord).toUpperCase();
                    for(int i = 1; i < fCharacter.length(); i++){
                        Character restOfChar = fCharacter.charAt(i);
                        newWord += restOfChar.toString().toLowerCase();
                    }
                    return firstWordUpperCase + newWord;
                }).sorted().forEach(name -> System.out.println(name));
    }


    //Class Exercise: 1.Counting 2.Listing name 3.Summing up
    public static long loanCount (Clients[] array){
        List <Clients> clients = Arrays.asList(array);
        return clients.stream().filter(element -> element.getLoanAmount() > 50_000).count();
    }
    public static void surnameOrder(Clients[] array){
        List <Clients> clients = Arrays.asList(array);
        clients.stream().filter(element -> element.getLoanAmount() > 10_000).map(surname -> surname.getSurname()).sorted().forEach(name -> System.out.println(name));
    }
    public static long loanOverdue (Clients[] array){
        long totalAmount = 0;
        List <Clients> clients = Arrays.asList(array);
        Set<Double> clientSet = clients.stream().
                filter(amount -> amount.getLoanAmount() > 75_000).
                filter(overdue -> overdue.isOverdue()).
                map(theAmount -> theAmount.getLoanAmount()).
                collect(Collectors.toSet());
        for (double eachClientAmount: clientSet){
            totalAmount += eachClientAmount;
        }
        return totalAmount;
    }
    public static void printLn(Clients[] array){
        System.out.println("The number of people that took loan greater than 50,000 is " + loanCount(array));
        System.out.println("Surnames of people that took loan greater than 10,000: ");
        surnameOrder(array);
        System.out.println("Total amount of loan of people whose loan is overdue and greater than 75,000: " + loanOverdue(array));
    }
}