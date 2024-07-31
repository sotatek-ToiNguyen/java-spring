package interview.me.spring.controller;

import interview.me.spring.model.dto.request.CreateStudentRequest;
import interview.me.spring.model.dto.request.UpdateStudentRequest;
import interview.me.spring.model.dto.response.StudentDetailResponse;
import interview.me.spring.model.enums.SubjectEnum;
import interview.me.spring.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/")
    public StudentDetailResponse createStudent(@Valid @RequestBody CreateStudentRequest request) {
        return studentService.createStudent(request);
    }

    @PutMapping("/{id}")
    public StudentDetailResponse updateStudent(@Valid @RequestBody UpdateStudentRequest request, @PathVariable("id") long id) {
        return studentService.updateStudent(request, id);
    }

    @DeleteMapping("/{id}")
    public boolean updateStudent(@PathVariable("id") long id) {
        return studentService.deletedStudent(id);
    }

    @GetMapping()
    public List<StudentDetailResponse> getListStudents(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String teacherName,
            @RequestParam(required = false) SubjectEnum subject
    ) {
        return studentService.getListStudents(firstName, teacherName, subject);
    }
}
