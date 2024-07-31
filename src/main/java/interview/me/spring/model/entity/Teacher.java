package interview.me.spring.model.entity;

import interview.me.spring.model.enums.SubjectEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "teachers")
@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    @Enumerated(EnumType.STRING)
    private SubjectEnum subject;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<Student> student;
}
