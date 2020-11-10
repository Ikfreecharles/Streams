public class Clients {
    private String name;
    private String surname;
    private double loanAmount;
    private boolean isOverdue;

    public Clients(String name, String surname, double loanAmount, boolean isOverdue){
        this.name = name;
        this.surname = surname;
        this.loanAmount = loanAmount;
        this.isOverdue = isOverdue;
    }
    protected String name(){
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public boolean isOverdue() {
        return isOverdue;
    }
}