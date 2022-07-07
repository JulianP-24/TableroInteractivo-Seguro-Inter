package edu.escuelaing.arsw.interactiveblackboard;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.escuelaing.arsw.interactiveblackboard.Model.MemCache;

@SpringBootApplication
public class BBAppStarter {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BBAppStarter.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
        app.run(args);
        MemCache memCache = new MemCache();
        System.out.println(memCache.getTicket());
        
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
        return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080; //returns default port if heroku-port isn't set (i.e. on localhost)
        }
}
