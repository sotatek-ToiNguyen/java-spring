package interview.me.spring.model.dto.response;

import interview.me.spring.model.entity.Student;
import interview.me.spring.model.entity.Teacher;
import interview.me.spring.model.enums.GenderEnum;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StudentDetailResponse {
    Long id;
    String firstName;
    String lastName;
    GenderEnum gender;
    String address;
    Teacher teacher;

    public static StudentDetailResponse from(final Student student) {
        return StudentDetailResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .address(student.getAddress())
                .gender(student.getGender())
                .teacher(Teacher.f)
                .build();
    }
}
