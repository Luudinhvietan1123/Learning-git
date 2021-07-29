package SelfLearnJuly2021.springboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document(collection = "Student")
public class Student {
    @Id
    private String id;

    @Field(value = "first_name")
    private String firstName;

    @Field(value = "last_name")
    private String lastName;

    @Field(value = "email")
    @Indexed(unique = true)
    private String email;

    @Field(value = "gender")
    private Gender gender;

    @Field(value = "address")
    private Address address;

    @Field(value = "favorite_subject")
    private List<String> favoriteSubjects;

    @Field(value = "total_spent_in_books")
    private BigDecimal totalSpentInBooks;

    @Field(value = "created")
    private LocalDateTime created;

    public Student(String firstName, String lastName, String email, Gender gender, Address address, List<String> favoriteSubjects, BigDecimal totalSpentInBooks, LocalDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.favoriteSubjects = favoriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", favoriteSubjects=" + favoriteSubjects +
                ", totalSpentInBooks=" + totalSpentInBooks +
                ", created=" + created +
                '}';
    }
}
