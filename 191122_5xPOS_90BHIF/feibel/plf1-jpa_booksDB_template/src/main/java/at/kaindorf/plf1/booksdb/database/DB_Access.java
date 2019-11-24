/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.kaindorf.plf1.booksdb.database;

import at.kaindorf.plf1.booksdb.pojos.Author;
import at.kaindorf.plf1.booksdb.pojos.Publisher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian Feibel
 */
public final class DB_Access {

    //ToDo implement singleton here
    private static DB_Access dbaccess;
    private EntityManager em;
    private EntityManagerFactory emf;

    public static DB_Access getInstance() {
        if (dbaccess == null) {
            dbaccess = new DB_Access();
        }
        return dbaccess;
    }

    public void connect() {
        emf = Persistence.createEntityManagerFactory("booksdb");
        em = emf.createEntityManager();

        //ToDo implement method here
    }

    public void disconnect() {
        em.close();
        emf.close();
        //ToDo implement method here
    }

    /**
     * read publisher from file /src/main/resources/publisher.csv and persist
     * Publisher-objects in database
     *
     * @throws IOException
     */
    public void importPublisher() throws IOException {

        String path = "user.dir" + File.separator + "src"
                + File.separator + "main" + File.separator
                + "resources" + File.separator + "publisher.csv";

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        
        String line = "";
        while((line = br.readLine())==null)
        {
            String[]parts = line.split(";");
            em.persist(new Publisher(Integer.parseInt(parts[0]), parts[1]));
        }
        em.flush();
        //ToDo implement method here
    }

    /**
     * use named query "Author.getAllAuthorsOfPublisher" to get a list
     * containing all authors of a specific publisher identified by the name of
     * the publisher The list is sorted ascending by the lastname of the author
     * The list does dot contain duplicates
     *
     * @param publishername
     * @return List of Authors
     */
    public List<Author> getAllAuthorsOfPublisher(String publishername) {
        //ToDo implement method here
        return null;
    }

    /**
     * use named query "Author.countBooksOfAuthor" to get the number of books of
     * one author with the specified lastname and the specified rank
     *
     * @return number of books
     */
    public Long countBooksOfAuthor(String lastname, int rank) {
        //ToDo implement method here
        return 0L;
    }

}
