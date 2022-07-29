package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    //Constructor
    public Movie(String name, String format , double rating){
        if(name == null || name.isBlank() ){
            throw new IllegalArgumentException("The movie name can not be null/Blank");
        }
        if(!(format.equals("DVD") || format.equals("Blue-Ray"))){
            throw new IllegalArgumentException("Format must be DVD or Blue-Ray");
        }
        if(rating<0 || rating >10){
            throw new IllegalArgumentException("Invalid Rating");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25 ;
        this.rentalPrice = format.equals("Blue-Ray") ? 1.99 : 0.99 ;

    }

    //Copy Constructor
    public Movie(Movie source){
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.isAvailable = source.isAvailable;
        this.sellingPrice = source.sellingPrice ;
        this.rentalPrice = source.rentalPrice;
    }

    //Getters
    public String getName() {

        return this.name;
    }
    public String getFromat() {
        return this.format;
    }
    public double getRating() {
        return this.rating;
    }
    public double getRentalPrice() {
        return this.rentalPrice;
    }
    public double getSellingPrice() {
        return this.sellingPrice;
    }
    public boolean isAvailable() {
        return this.isAvailable;
    }

    //Setters

    public void setName(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can not be null/Blank");
        }
        this.name = name;
    }
    public void seFormat(String format){
        if(format == null || format.isBlank() ){
            throw new IllegalArgumentException("Movie Format can not be null/Blank");
        }
        if(!(format.equals("DVD") || format.equals("Blue-Ray"))){
            throw new IllegalArgumentException("Format must be 'DVD' or 'Blue-Ray' ");
        }
        this.format = format;
        this.sellingPrice = format.equals("Blue-Ray") ? 4.25 : 2.25 ;
        this.rentalPrice = format .equals("Blue-Ray") ? 1.99 : 0.99 ;
    }
    public void setRating(double rating){
        if(rating <0 || rating>10){
            throw new IllegalArgumentException("Invalid Rating");
        }
        this.rating = rating;
    }
    private void setSellingPrice(double sellingPrice){
        this.sellingPrice = sellingPrice;
    }
    private void setRentalPrice(double rentalPrice){
        this.rentalPrice = rentalPrice;
    }
    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable ;
    }

    //Methods
    public String toString(){
        return "\t Name: " + name + "\n" +

                "\t Format: " + format + "\n" +

                "\t Rating: " + rating + "\n" +

                "\t Selling Price: " + sellingPrice + "\n" +

                "\t Rental Price: " + rentalPrice + "\n" +

                "\t Availability: " + ((isAvailable)? "In-Stock " : " Rented ")+ "\n";
    }

}
