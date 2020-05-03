package gr.codehub.app;

public class Customer {
    //fields
    private String name;
    private Basket basket;
    private Payment payment;

    //constructors
    public Customer(String name) {
        this.name = name;
        this.basket = new Basket();
        this.payment = new Payment();
    }
    public Customer(String name, Basket basket) {
        this.basket = basket;
        this.name = name;
        this.payment = new Payment();
    }

    //getter methods, accessors

    public String getName() {
        return name;
    }
    public Payment getPayment() {
        return payment;_
    }
    public Basket getBasket() {
        return basket;
    }



    //setter methods,  mutators, modifiers
    public void setName(String name) {
        this.name = name;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
    public void setPayment(Payment payment) {
        this.payment.create();
    }
    //toString
    public String toString() {
        return "Name: " + this.name + "/n" + "Basket:" + getBasket().toString();
    }

}
