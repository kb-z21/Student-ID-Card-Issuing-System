package com.kibrom.student_id_system.service;


import com.kibrom.student_id_system.entity.ProgramType;
import org.springframework.stereotype.Service;



@Service
public class UniversityEmailGeneratorService {



    public String generateEmail(
            String firstName,
            String lastName,
            ProgramType program,
            Integer startYear
    ) {


        String programCode = switch(program) {

            case REGULAR -> "reg";

            case NIGHT -> "night";

            case WEEKEND -> "weekend";

        };


        return firstName.toLowerCase()
                + lastName.toLowerCase()
                + "+"
                + programCode
                + startYear
                + "@hu.edu.et";

    }

}