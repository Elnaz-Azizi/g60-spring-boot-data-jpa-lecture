package se.lexicon.g60springbootdatajpalecture.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.Objects;

//@Table(name = "tbl-user_profile")
/*
CREATE TABLE tbl_user_profile (){
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(100),
    phone_number VARCHAR(255),
    bio TEXT,
    address VARCHAR(255),
    profile_image binary,
}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "tbl_user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nickname;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 600)
    private String bio;

    @Column(length = 255)
    private String address;

    @Lob // Long Object Binary
    @Column( length = 1000000) // around 1MB
    private byte[] profileImage;



}
