package interview.me.spring.model.entity;

import interview.me.spring.model.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "students")
@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private short age;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ManyToOne()
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false)
    private Teacher teacher;
}
