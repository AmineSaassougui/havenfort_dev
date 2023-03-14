package com.camp.havenfort_dev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ActivityLike {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idActivityLike;
    @Enumerated(EnumType.STRING)
    Reaction react;
    @JsonIgnore
    LocalDateTime dateLike;
    @JsonIgnore
    @ManyToOne
    User user;
    @JsonIgnore
    @ManyToOne
    Activity activity;

}
