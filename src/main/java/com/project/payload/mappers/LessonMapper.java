package com.project.payload.mappers;

import com.project.entity.concretes.business.Lesson;
import com.project.payload.request.business.LessonRequest;
import com.project.payload.response.business.LessonResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LessonMapper {

    public Lesson mapLessonRequestToLesson(LessonRequest lessonRequest){

        return Lesson.builder()
                .lessonName(lessonRequest.getLessonName())
                .creditScore(lessonRequest.getCreditScore())
                .isCompulsory(lessonRequest.getIsCompulsory())
                .build();
    }

    public LessonResponse mapLessonToLessonResponse(Lesson lesson){

        return LessonResponse.builder()
                .lessonId(lesson.getLessonId())
                .lessonName(lesson.getLessonName())
                .creditScore(lesson.getCreditScore())
                .isCompulsory(lesson.getIsCompulsory())
                .build();
    }

    public Lesson mapLessonRequestToUpdatedLesson(Long lessonId, LessonRequest lessonRequest){

        return Lesson.builder()
                .lessonId(lessonId)
                .lessonName(lessonRequest.getLessonName())
                .creditScore(lessonRequest.getCreditScore())
                .isCompulsory(lessonRequest.getIsCompulsory())
                .build();
    }
}