package models;

import java.util.ArrayList;

public class Store {
    private ArrayList<Movie> movies = new ArrayList<Movie>(); 
    
    // Constructor
    public Store(){
        this.movies = new ArrayList<Movie>();
    }

    // Getter
    public Movie getMovies(int index) {
        return new Movie(movies.get(index));
    }

    public Movie getMovies(String name){
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getName().equals(name)){
                return movies.get(i);
            }
        }
        return null;
    }


    // Setter
    public void setMovie(int index , Movie movie){
        movies.set(index, new Movie(movie));
    }

    // Methods
    // 1. Add Movie
    public void addMovie(Movie movie){
        movies.add(new Movie(movie));
    }

    // Action
    public void action(String movieName , String action){
        if(!(action.equals("sell") || action.equals("rent") || action.equals("return"))){
            throw new IllegalArgumentException("The action can be 'sell', 'rent' or 'return' ");
        }
        if(movieName == null || movieName.isBlank() ){
            throw new IllegalArgumentException();
        }
        if(movies.isEmpty()){
            throw new IllegalStateException("Store not in a valid state to perform action");
        }
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getName().equals(movieName)){
                switch(action){
                    case "sell" : 
                    if(!(this.movies.get(i).isAvailable())){
                        throw new IllegalStateException("can not sell a movie that is rented out");
                    }
                    this.movies.remove(i); break;
                    case "rent" : movies.get(i).setIsAvailable(false); break;
                    case "return" : movies.get(i).setIsAvailable(true); break;
                }
            }
        }
    }

    // toString
    public String toString(){
        String temp = "\n";
        for (int i = 0; i < movies.size(); i++) {
            temp+=movies.get(i).toString();
            temp+="\n";
        }
        return temp;
    }


    // 2. Sell Movie
    // public void sellMovie(String movieName){
    //     for (int i = 0; i < movies.size(); i++) {
    //         if(movies.get(i).getName().equals(movieName)){
    //             movies.remove(i);
    //         }
    //     }
    // }
    // // 3. Rent Movie
    // public void rentMovie(String movieName) {
    //     for (int i = 0; i < movies.size(); i++) {
    //         if(movies.get(i).getName().equals(movieName)){
    //             movies.get(i).setIsAvailable(false);
    //         }
    //     }
    // }
    // //4. Return Movie
    // public void returnMovie(String movieName){
    //     for (int i = 0; i < movies.size(); i++) {
    //         if(movies.get(i).getName().equals(movieName)){
    //             movies.get(i).setIsAvailable(true);
    //         }
    //     }
    // }

}
