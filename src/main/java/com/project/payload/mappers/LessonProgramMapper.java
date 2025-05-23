package com.project.payload.mappers;

import com.project.entity.concretes.business.EducationTerm;
import com.project.entity.concretes.business.Lesson;
import com.project.entity.concretes.business.LessonProgram;
import com.project.payload.request.business.LessonProgramRequest;
import com.project.payload.response.business.LessonProgramResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Set;

@Data
@Component
public class LessonProgramMapper {

    public LessonProgram mapLessonProgramRequestToLessonProgram(LessonProgramRequest lessonProgramRequest,
                                                                Set<Lesson> lessonSet,
                                                                EducationTerm educationTerm) {
        return LessonProgram.builder()
                .day(lessonProgramRequest.getDay())
                .startTime(lessonProgramRequest.getStartTime())
                .stopTime(lessonProgramRequest.getStopTime())
                .lessons(lessonSet)
                .educationTerm(educationTerm)
                .build();
    }

    public LessonProgramResponse mapLessonProgramToLessonProgramResponse(LessonProgram lessonProgram) {

        return LessonProgramResponse.builder()
                .day(lessonProgram.getDay())
                .startTime(lessonProgram.getStartTime())
                .stopTime(lessonProgram.getStopTime())
                .lessonProgramId(lessonProgram.getId())
                .lessonName(lessonProgram.getLessons())
                .build();
    }
}
