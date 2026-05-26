package se.lexicon.g60springbootdatajpalecture.entity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"createdBy", "participants"})
@ToString(exclude = {"createdBy", "participants"})

@Entity
@Table(name = "events")
public class Event {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @UuidGenerator(style = UuidGenerator.Style.TIME)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    private String description;

    @Setter
    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Setter
    private String location;

    @Setter
    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @Setter
    @ManyToOne
    @JoinColumn(name = "created_by_user_id")
    private User createdBy;


    @ManyToMany
    @JoinTable(
            name = "event_participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> participants = new HashSet<>();

    public void addParticipant(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        participants.add(user);
    }

    public void removeParticipant(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        participants.remove(user);
    }
}
