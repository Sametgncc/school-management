package com.project.service.business;

import com.project.entity.concretes.business.LessonProgram;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class LessonProgramService {
    public Set<LessonProgram> getLessonProgramById(@NotNull(message = "Please select Lesson") Set<Long> lessonIdList) {
    }
}
