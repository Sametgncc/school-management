package com.project.controller.business;

import com.project.payload.request.business.LessonProgramRequest;
import com.project.payload.response.business.LessonProgramResponse;
import com.project.payload.response.business.ResponseMessage;
import com.project.service.business.LessonProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/lessonPrograms")
@RequiredArgsConstructor
public class LessonProgramController {
    private final LessonProgramService lessonProgramService;

    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER',ASSISTANT_MANAGER')")
    public ResponseMessage<LessonProgramResponse> saveLessonProgram(@RequestBody @Valid
                                                                    LessonProgramRequest lessonProgramRequest) {
        return lessonProgramService.saveLessonProgram(lessonProgramRequest);
    }

    @GetMapping("/getAll") // http://localhost:8080/lessonPrograms/getAll
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','STUDENT','TEACHER')")
    public List<LessonProgramResponse> getAllLessonPrograms() {
        return lessonProgramService.getAllLessonPrograms();
    }

    // getById yazilacak

    // herhangi bir kullanici atamasi yapilmamis olan ders programlarini listele
    @GetMapping("/getAllUnassigned") // http://localhost:8080/lessonPrograms/getAllUnassigned
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANT_MANAGER','STUDENT','TEACHER')")
    public List<LessonProgramResponse> getAllUnassigned(){
        return lessonProgramService.getAllUnassigned();
    }

    // getAllLessonProgramAssigned

    // delete()

    // getAllWithPage


    // bir ogretmen kendine ait olan ders programini getiriyor
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    @GetMapping("/getAllLessonByTeacher") // http://localhost:8080/lessonPrograms/getAllLessonByTeacher
    public Set<LessonProgramResponse> getAllLessonProgramByTeacher(HttpServletRequest httpServletRequest){

        return lessonProgramService.getAllLessonProgramByUser(httpServletRequest);
    }

    @PreAuthorize("hasAnyAuthority('STUDNET')")
    @GetMapping("/getAllLessonByTeacher") // http://localhost:8080/lessonPrograms/getAllLessonByTeacher
    public Set<LessonProgramResponse> getAllLessonProgramByStudent(HttpServletRequest httpServletRequest){

        return lessonProgramService.getAllLessonProgramByUser(httpServletRequest);
    }


}
