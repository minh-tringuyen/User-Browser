package io.labs5150.breach.browser.repo;

import io.labs5150.breach.browser.model.FBUser;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FBUserRepository extends PagingAndSortingRepository<FBUser, Integer>{
    
    List<FBUser> findAllByFirstName(String fn);
    List<FBUser> findAllByLastName(String ln);
    List<FBUser> findAllByFirstNameAndLastName(String fn, String ln);
    List<FBUser> findAllByFirstNameStartingWith (String fn);
    List<FBUser> findAllByLastNameStartingWith (String ln);
    List<FBUser> findAllByFirstNameEndingWith (String fn);
    List<FBUser> findAllByLastNameEndingWith (String ln);
    List<FBUser> findAllByLastNameStartingWithAndFirstName (String ln, String fn);
    List<FBUser> findAllByFirstNameStartingWithAndLastName (String fn, String ln);
    List<FBUser> findAllByFirstNameStartingWithAndFirstNameEndingWith(String fn, String fnEnd);
    List<FBUser> findAllByLastNameStartingWithAndLastNameEndingWith(String ln, String lnEnd);
    List<FBUser> findAllByFirstNameContaining (String fn);
    List<FBUser> findAllByLastNameContainingAndFirstName (String ln, String fn);
    List<FBUser> findAllByFirstNameContainingAndLastName (String fn, String ln);
    List<FBUser> findAllByLastNameContaining (String ln);
    List<FBUser> findAllByFirstNameContainingAndLastNameContaining(String fn, String ln);
    List<FBUser> findAllByFirstNameStartingWithAndFirstNameEndingWithAndLastName(String fn, String fnEnd, String ln);
    List<FBUser> findAllByLastNameStartingWithAndLastNameEndingWithAndFirstName(String ln, String lnEnd, String fn);
    List<FBUser> findAllByFirstNameStartingWithAndLastNameContaining (String fn, String ln);
    List<FBUser> findAllByFirstNameContainingAndLastNameStartingWith (String fn, String ln);
    //List<FBUser> findAllByFirstNameStartingWithAndFirstNameEndingWith (String fn, String fnEnd);
    //List<FBUser> findAllByFirstNameStartingWith("Ea").and(findAllByFirstNameEndingWith("fw"));

    
}
