package no.espenmeidell.ressys.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(
        indexes = {
                @Index(columnList = "from", name = "from"),
                @Index(columnList = "to", name = "to")
        }
)
public class Reservation {

    @Id
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private ReservableEntity reservableEntity;
    private int places;
    private LocalDate from;
    private LocalDate to;

    protected Reservation() {}

    public Reservation(String name, String phone, String email, ReservableEntity reservableEntity, int places, LocalDate from, LocalDate to) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.reservableEntity = reservableEntity;
        this.places = places;
        this.from = from;
        this.to = to;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ReservableEntity getReservableEntity() {
        return reservableEntity;
    }

    public void setReservableEntity(ReservableEntity reservableEntity) {
        this.reservableEntity = reservableEntity;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", reservableEntity=" + reservableEntity +
                ", places=" + places +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
