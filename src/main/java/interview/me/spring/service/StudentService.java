package interview.me.spring.service;

import interview.me.spring.exception.NotFoundException;
import interview.me.spring.model.dto.request.CreateStudentRequest;
import interview.me.spring.model.dto.request.UpdateStudentRequest;
import interview.me.spring.model.dto.response.StudentDetailResponse;
import interview.me.spring.model.entity.Student;
import interview.me.spring.model.entity.Teacher;
import interview.me.spring.model.enums.SubjectEnum;
import interview.me.spring.repository.StudentRepository;
import interview.me.spring.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public StudentDetailResponse createStudent(CreateStudentRequest request) {
        final Teacher teacher = teacherRepository.findFirstById(request.getTeacherId());
        if (teacher == null) {
            throw new NotFoundException("404", "Teacher not found");
        }
        final Student student = Student.builder()
                .age(request.getAge())
                .firstName(request.getFistName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .gender(request.getGender())
                .teacherId(request.getTeacherId())
                .teacher(teacher)
                .build();
        final Student saveStudent = studentRepository.save(student);
        return StudentDetailResponse.from(saveStudent);
    }

    public StudentDetailResponse updateStudent(UpdateStudentRequest request, long id) {
        final Student student = studentRepository.findFirstById(id);
        System.out.println(student.getTeacher().getSubject());
        if (student == null) {
            throw new NotFoundException("404", "Student not found");
        }

        student.setAddress(request.getAddress());
        student.setAge(request.getAge());
        student.setGender(request.getGender());
        student.setFirstName(request.getFistName());
        student.setLastName(request.getLastName());
        final Student updateStudent = studentRepository.save(student);
        return StudentDetailResponse.from(updateStudent);
    }

    public boolean deletedStudent(long id) {
        final Student student = studentRepository.findFirstById(id);
        if (student == null) {
            throw new NotFoundException("404", "Student not found");
        }
        studentRepository.deleteById(id);
        return true;
    }

    public List<StudentDetailResponse> getListStudents(String name, String teacherName, SubjectEnum subject) {
        if (name == null && teacherName == null && subject == null) {
            List<Student> students = studentRepository.findAll();
            return students.stream().map(StudentDetailResponse::from).toList();
        } else if (name != null && (teacherName != null || subject != null)) {
            List<Student> students1 = studentRepository.findAllByNameAndTeacher(name, teacherName, subject);
            return students1.stream().map(StudentDetailResponse::from).toList();
        } else if (name != null && teacherName == null && subject == null) {
            List<Student> students1 = studentRepository.findAllByFirstName(name);
            return students1.stream().map(StudentDetailResponse::from).toList();
        } else {
            List<Student> students1 = studentRepository.findAllByTeacher(teacherName, subject);
            return students1.stream().map(StudentDetailResponse::from).toList();
        }
    }
}
