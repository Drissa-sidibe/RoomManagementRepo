package com.saraya.RoomManagement.controller;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoomConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(RoomRepository repository){
        return args -> {


           Room camp= new Room(
                            4,
                            7,
                   73860880
                                       );
            Room res= new Room(
                    0,
                    9,
                    325578789
            );
            Room c= new Room(
                    0,
                    6,
                    789789789
            );

            Room d= new Room(
                    0,
                    8,
                    676668666
            );
            repository.saveAll(List.of(camp,res,c,d));

        };
    }
}
