package com.kibrom.student_id_system.service;


import com.kibrom.student_id_system.entity.ProgramType;
import org.springframework.stereotype.Service;


import java.util.EnumMap;
import java.util.Map;


@Service
public class StudentIdGeneratorService {


    private final Map<ProgramType, Integer> sequences =
            new EnumMap<>(ProgramType.class);



    public StudentIdGeneratorService() {

        sequences.put(ProgramType.REGULAR, 0);
        sequences.put(ProgramType.NIGHT, 0);
        sequences.put(ProgramType.WEEKEND, 0);

    }



    public String generateStudentId(ProgramType program) {


        int nextNumber =
                sequences.get(program) + 1;


        sequences.put(program, nextNumber);



        String prefix = switch(program) {

            case REGULAR -> "STU-R";

            case NIGHT -> "STU-N";

            case WEEKEND -> "STU-W";

        };



        return String.format(
                "%s-%06d",
                prefix,
                nextNumber
        );

    }

}