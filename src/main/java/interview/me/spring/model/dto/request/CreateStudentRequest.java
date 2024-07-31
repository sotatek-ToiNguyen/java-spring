package interview.me.spring.model.dto.request;

import interview.me.spring.model.enums.GenderEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateStudentRequest {
    @NotEmpty
    Long teacherId;

    @NotEmpty
    String fistName;

    @NotEmpty
    String lastName;

    @NotEmpty
    short age;

    @NotEmpty
    String address;

    @NotEmpty
    GenderEnum gender;
}
