import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import models.Movie;
import models.Store;

public class Main {
    static Store store = new Store();
    public static void main(String[] args) {

        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try{
            loadMovies("movies.txt");
            System.out.println("MOVIES LOADED\n\n");
            System.out.println(store);
            manageMovies();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("\nProcess Complete.");
        }


        
               




    }

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */
    public static void manageMovies(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return.");
            String responce = scan.nextLine();
            System.out.println("\nEnter the name of the movie.");
            String moviename = scan.nextLine();
            if(moviename == null || moviename.isBlank()){
                throw new IllegalArgumentException("\n\nThe input you provided is not valid. Please try again\n");
            }
            if(store.getMovies(moviename)==null){
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }
            switch(responce){
                case "a" : 
                if(!(store.getMovies(moviename).isAvailable())){
                    System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                    continue;
                }
                store.action(moviename, "sell"); break;
                case "b" : store.action(moviename, "rent"); break;
                case "c" : store.action(moviename, "return"); break;
            }
            System.out.println("\n\nUPDATED MOVIES\n\n");
            System.out.println(store);

        }
    }


    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */
    public static void loadMovies(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis);
        while(scan.hasNextLine()){
            String line =scan.nextLine();
            String[] words = line.split("--");
            Movie newMovie = new Movie(words[0],words[1],Double.parseDouble(words[2]));
            store.addMovie(newMovie);
        }
        scan.close();
    }

}
