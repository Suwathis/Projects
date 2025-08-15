package com.mentalhealth.controller;

import com.mentalhealth.model.*;
import com.mentalhealth.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MoodController {

    @Autowired private UserRepository userRepo;
    @Autowired private MoodEntryRepository moodRepo;
    @Autowired private MoodTipRepository tipRepo;
    
    
    @PostMapping("/submit")
    public void submitMood(@RequestParam String alias,
            @RequestParam String mood,
            @RequestParam String description,
            HttpServletResponse response) throws IOException {
        User user = userRepo.findByAlias(alias).orElseGet(() -> {//This line checks if a user with the given alias already exists.If yes: use that user.
                                       
            User newUser = new User();//If no: create a new user and save it to the database.
            newUser.setAlias(alias);
            return userRepo.save(newUser);
        });

        MoodEntry entry = new MoodEntry();//Creates a new MoodEntry object.Sets the user, mood, and description.Saves it to the mood_entry table.
        entry.setUser(user);
        entry.setMood(mood);
        entry.setDescription(description);
        moodRepo.save(entry);

        List<MoodTip> tips = tipRepo.findByMood(mood);
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html><html><head><title>Mood Tips</title>");
        html.append("<link rel='stylesheet' href='/css/style.css'></head><body>");
        html.append("<h1>Self-Help Tips</h1><ul>");
        for (MoodTip tip : tips) {
            html.append("<li>").append(tip.getTipText()).append("</li>");
        }
        html.append("</ul><a href='/'>Go Back</a></body></html>");

        response.setContentType("text/html");
        response.getWriter().write(html.toString());
        
        
    }
}
//This file belongs to the controller package, which holds classes that manage HTTP requests and responses.
//These import statements bring in your model and repository classes, and Spring MVC annotations like @Controller, @GetMapping
//The @Controller annotation tells Spring that this class handles web requests and returns views (HTML pages).
//This line is injecting a dependency — specifically, an instance of the UserRepository interface — into your controller class (MoodController).
//The keyword @Autowired tells Spring Boot to automatically create and provide (inject) the required object from the Spring context.
//UserRepository:This is an interface that extends JpaRepository, used to perform database operations on User entities (like findById, save, delete, etc).
//userRepo:This is the name of the variable. You can call it anything, but by convention it's short for "user repository".
//When the user visits the homepage (e.g., http://localhost:8080/), this method returns the index.html form.It does not perform any logic — just shows the input form.
//This method runs when the user submits the form.@RequestParam gets the input values from the HTML form: alias, mood, and description.
//Model is used to pass data to the next HTML page.
//List<MoodTip> tips = tipRepo.findByMood(mood) This fetches a list of tips from the database that match the user's selected mood.
//Example: if mood is "Sad", it finds tips like "Talk to a friend", "Go for a walk".
//Initializes a new string builder to create a dynamic HTML page.
//Begins writing the HTML document.Adds a title and links a CSS file for styling (/css/style.css).
//Adds a heading and starts an unordered list (<ul>) to show tips as bullet points.
//Loops through each tip from the database and adds it as a <li> (list item).tip.getTipText()returns the actual tip text (e.g., "Meditate for 5 minutes").
//Closes the unordered list and adds a "Go Back" link to return to the main page.Closes the HTML tags.
//Tells the browser that the server is sending HTML content.
//Sends the final HTML string to the browser so the user sees the tips.









