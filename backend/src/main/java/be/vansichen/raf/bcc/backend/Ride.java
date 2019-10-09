package be.vansichen.raf.bcc.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ride {

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;
    private LocalDate date;
    private String description;
    private Integer distance;
    @OneToMany
    private Collection<Member> participants;

    private Ride(){};

    public Ride(LocalDate date, String description, Member... participants) {
        this.date = date;
        this.description = description;
        this.participants = new HashSet<>();
        for (Member participant: participants){
            this.participants.add(participant);
        }
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDistance() {
        return distance;
    }

    public Collection<Member> getParticipants(){
        return participants;
    }
}
