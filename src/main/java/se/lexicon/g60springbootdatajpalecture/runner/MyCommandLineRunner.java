package se.lexicon.g60springbootdatajpalecture.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.g60springbootdatajpalecture.entity.User;
import se.lexicon.g60springbootdatajpalecture.entity.UserProfile;
import se.lexicon.g60springbootdatajpalecture.repository.UserProfileRepository;
import se.lexicon.g60springbootdatajpalecture.repository.UserRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;

    @Autowired
    public MyCommandLineRunner(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //System.out.println("##################################");
        User userData = new User();
        userData.setEmail("user1@test.se");
        userData.setFullName("user 1");

        UserProfile userProfileData = new UserProfile();
        userProfileData.setNickname("USR");

       User savedUser  = userRepository.save(userData);
       userProfileData.setUser(savedUser);

       UserProfile savedUserProfile = userProfileRepository.save(userProfileData);


    }
}
