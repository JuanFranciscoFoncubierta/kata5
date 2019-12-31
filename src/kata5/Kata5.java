package kata5;


public class Kata5 {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:/Users/javidiazdom/Documents/GitHub/Kata5/DB_SQLite/DB.db";
        DataBase db = new DataBase(url);
        db.open();
        
        db.select_PERSONAS();
        
        Person person = new Person("yo", "Pls", "Marketing");
        db.insert_PERSONAS(person);
        
        System.out.println("");
        
        db.select_PERSONAS();
        db.close();
    }
    
}
