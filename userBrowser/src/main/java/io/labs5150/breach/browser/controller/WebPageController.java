package io.labs5150.breach.browser.controller;

import io.labs5150.breach.browser.model.FBUser;
import io.labs5150.breach.browser.repo.FBUserRepository;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebPageController {

    private static final Logger logger = LoggerFactory.getLogger(WebPageController.class);

    @Autowired
    FBUserRepository fbUserRepo;

    public WebPageController() {
    }

    @PostConstruct
    private void postConstruct() {
        logger.debug("Starting ....");
        Optional<FBUser> fbUser = fbUserRepo.findById(3);
        if (fbUser.isPresent()) {
            logger.debug("Test Query returned correctly: {},{}", fbUser.get().getLastName(), fbUser.get().getFirstName());
        } else {
            logger.error("No data in database! Exiting!");
            System.exit(100);
        }
    }

    @PreDestroy
    private void preDestroy() {
    }

    @RequestMapping("/")
    public ModelAndView indexPage(Map<String, Object> model, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        if (firstName != null && lastName != null) {
            model.put("searchTerm", firstName);
            model.put("searchTerm2", lastName);
            
            List<FBUser> list = null;
            if(firstName.contains("*") && "".equals(lastName)){
                logger.debug("Running query for users with wildcard: {}", firstName);
                int n = firstName.length();
                char last = firstName.charAt(n - 1);
                // first name containing
                if(firstName.charAt(0)== '*' && last == '*'){
                    list = fbUserRepo.findAllByFirstNameContaining(firstName.replace("*", ""));
                }
                else if(last == '*'){ 
                    list = fbUserRepo.findAllByFirstNameStartingWith(firstName.replace("*", ""));
                }
                else{
                    firstName = firstName.replace("*", ",");
                    String[] split = firstName.split(",");
                    logger.debug("split values are", split[0], split[1]);
                    list = fbUserRepo.findAllByFirstNameStartingWithAndFirstNameEndingWith(split[0], split[1]);
                }
                //list = fbUserRepo.findAllByFirstNameStartingWith(firstName.replace("*", ""));
            }
            else if(lastName.contains("*") && "".equals(firstName)){
                logger.debug("Running query for users with wildcard: {}", firstName);
                int n = lastName.length();
                char last = lastName.charAt(n - 1);
                if(lastName.charAt(0)== '*' && last == '*'){
                    list = fbUserRepo.findAllByLastNameContaining(lastName.replace("*", ""));
                }
                else if(last == '*'){
                    list = fbUserRepo.findAllByLastNameStartingWith(lastName.replace("*", ""));
                }
                else{
                    lastName = lastName.replace("*", ",");
                    String[] split = lastName.split(",");
                    logger.debug("split values are", split[0], split[1]);
                    list = fbUserRepo.findAllByLastNameStartingWithAndLastNameEndingWith(split[0], split[1]);
                }
                //list = fbUserRepo.findAllByLastNameStartingWith(lastName.replace("*", ""));
            }
            else if(firstName.contains("*") && lastName.contains("*")){
                logger.debug("Running query for users with wildcard: {}", firstName);
                int n = firstName.length();
                char firstLast = firstName.charAt(n - 1);
                int j = lastName.length();
                char lastLast = lastName.charAt(j - 1);
                if(firstName.charAt(0)== '*' && firstLast == '*' && lastName.charAt(0) == '*' && lastLast == '*'){
                    list = fbUserRepo.findAllByFirstNameContainingAndLastNameContaining(firstName.replace("*", ""), lastName.replace("*", ""));
                }
                else if (firstLast == '*' && lastName.charAt(0)== '*' && lastLast == '*'){
                    list = fbUserRepo.findAllByFirstNameStartingWithAndLastNameContaining(firstName.replace("*", "") , lastName.replace("*",""));
                }
                else if(firstName.charAt(0) == '*' && firstLast == '*' &&lastLast == '*'){
                    list = fbUserRepo.findAllByFirstNameContainingAndLastNameStartingWith(firstName.replace("*", ""), lastName.replace("*",""));
                }
                else if(firstName.charAt(0)== '*' && firstLast == '*' && lastName.contains("*")){
                    
                }
                //firstname containing and last name starting with and ending with
                //first name starting with and ending with and last name containing
                // firstname starting with and last name starting with and ending with
                //first name starting with and ending with and last name starting with
                //first name starting with and ending with and last name starting with and ending with
                
                //else if(){}
            }
            else if (firstName.contains("*") && !"".equals(lastName)) {
                logger.debug("Running query for users with wildcard: {}", firstName);
                int n = firstName.length();
                char last = firstName.charAt(n - 1);
                if(firstName.charAt(0)== '*' && last == '*'){
                    list = fbUserRepo.findAllByFirstNameContainingAndLastName(firstName.replace("*", ""), lastName);
                }
                else if(last == '*'){
                    list = fbUserRepo.findAllByFirstNameStartingWithAndLastName(firstName.replace("*", ""), lastName);
                }
                else{
                    firstName = firstName.replace("*", ",");
                    String[] split = firstName.split(",");
                    logger.debug("split values are", split[0], split[1]);
                    list = fbUserRepo.findAllByFirstNameStartingWithAndFirstNameEndingWithAndLastName(split[0], split[1], lastName);
                }
            }
            else if (!"".equals(firstName) && lastName.contains("*")){
                logger.debug("Running query for users with wildcard: {}", firstName);
                int n = lastName.length();
                char last = lastName.charAt(n - 1);
                if(lastName.charAt(0)== '*' && last == '*'){
                    list = fbUserRepo.findAllByLastNameContainingAndFirstName(lastName.replace("*", ""), firstName);
                }
                else if(last == '*'){
                    list = fbUserRepo.findAllByLastNameStartingWithAndFirstName(lastName.replace("*", ""), firstName);
                }
                else{
                    lastName = lastName.replace("*", ",");
                    String[] split = lastName.split(",");
                    logger.debug("split values are", split[0], split[1]);
                    list = fbUserRepo.findAllByLastNameStartingWithAndLastNameEndingWithAndFirstName(split[0], split[1], firstName);
                }
            }
            
            else if (!"".equals(firstName) && !"".equals(lastName)) {
                logger.debug("Running query for users with first name and last name: {}", firstName, lastName);
                list = fbUserRepo.findAllByFirstNameAndLastName(firstName, lastName);
            }
            else if (!"".equals(firstName) && "".equals(lastName)) {
                logger.debug("Running query for users with first name: {}", firstName);
                list = fbUserRepo.findAllByFirstName(firstName);
            }
            else if ("".equals(firstName) && !"".equals(lastName)) {
                logger.debug("Running query for users with last name: {}", lastName);
                list = fbUserRepo.findAllByLastName(lastName);
            }
            if (list != null) {
                model.put("fbusers", list);
                model.put("count", list.size());
                model.put("hasData", 1);
                logger.debug("Returning {} rows", list.size());
            } else {
                logger.debug("No data for {}", firstName," and ", lastName);
            }
            
            
        }
        /*else if (firstName != null && "".equals(lastName)) {
            model.put("searchTerm", firstName);
            logger.debug("Running query for users with first name: {}", firstName);
            List<FBUser> list = fbUserRepo.findAllByFirstName(firstName);
            if (list != null) {
                model.put("fbusers", list);
                model.put("count", list.size());
                model.put("hasData", 1);
                logger.debug("Returning {} rows", list.size());
            } else {
                logger.debug("No data for {}", firstName);
            }
            
            
        }
        else if ("".equals(firstName) && lastName != null) {
            model.put("searchTerm", lastName);
            logger.debug("Running query for users with last name: {}", lastName);
            List<FBUser> list = fbUserRepo.findAllByLastName(lastName);
            if (list != null) {
                model.put("fbusers", list);
                model.put("count", list.size());
                model.put("hasData", 1);
                logger.debug("Returning {} rows", list.size());
            } else {
                logger.debug("No data for {}", lastName);
            }
            
            
        }
        else if ("".equals(firstName) && "".equals(lastName)){
            System.out.println("No input given");
        }*/
        model.put("title", "FB Browser");
        model.put("generated", new Date());
        logger.debug("Returning Index");
        return new ModelAndView("index", model);
    }

}
