package com.scheronlini.apiRestfulmongodb.config;

import com.scheronlini.apiRestfulmongodb.domain.Post;
import com.scheronlini.apiRestfulmongodb.domain.User;
import com.scheronlini.apiRestfulmongodb.repository.PostRepository;
import com.scheronlini.apiRestfulmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.regex.Pattern;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"),"Partiu Viagem", "Vou viajar para São Paulo. Abraços",maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"),"Bom dia", "Acordei feliz hoje!",maria);

        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
