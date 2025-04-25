package com.project.service.business;

import com.project.entity.concretes.business.Lesson;
import com.project.exception.ConflictException;
import com.project.payload.mappers.LessonMapper;
import com.project.payload.messages.ErrorMessages;
import com.project.payload.messages.SuccessMessages;
import com.project.payload.request.business.LessonRequest;
import com.project.payload.response.business.LessonResponse;
import com.project.payload.response.business.ResponseMessage;
import com.project.repository.business.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;


    public ResponseMessage<LessonResponse> saveLesson(@Valid LessonRequest lessonRequest) {
        isLessonExistsByLessonName(lessonRequest.getLessonName());
        Lesson savedLesson =lessonRepository.save(lessonMapper.mapLessonRequestToLesson(lessonRequest));

        return ResponseMessage.<>builder()
                .object(lessonMapper.mapLessonToLessonResponse(savedLesson))
                .message(SuccessMessages.LESSON_SAVE)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    private boolean isLessonExistsByLessonName(String lessonName) {
        boolean lessonExist=lessonRepository.existsLessonByLessonNameEqualsIgnoreCase(lessonName);

        if (lessonExist) {
           throw new ConflictException(ErrorMessages.LESSON_PROGRAM_ALREADY_EXIST);
        } else {
            return false;
        }
    }
}
