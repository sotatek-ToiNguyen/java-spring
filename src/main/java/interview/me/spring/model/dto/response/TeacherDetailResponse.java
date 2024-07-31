package interview.me.spring.model.dto.response;

import interview.me.spring.model.entity.Teacher;
import interview.me.spring.model.enums.SubjectEnum;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TeacherDetailResponse {
    Long id;
    String name;
    String address;
    SubjectEnum subject;

    public static TeacherDetailResponse from(final Teacher teacher) {
        return TeacherDetailResponse.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .address(teacher.getAddress())
                .subject(teacher.getSubject())
                .build();
    }
}
