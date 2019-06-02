//package com.picpay.example.bootstrap;
//
//import com.picpay.example.repositories.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//
//public class BootstrapData implements CommandLineRunner {
//    private final UserRepository userRepository;
//
//    public BootstrapData(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    @Override
//    public void run(String...args) throws Exception{
//
//        System.out.println("Loading Data");
//
//        System.out.println("User in database: " + userRepository.count());
//    }
//}
