package no.espenmeidell.ressys.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(
        indexes = {
                @Index(columnList = "fromDate", name = "fromDate"),
                @Index(columnList = "toDate", name = "toDate")
        }
)
public class Reservation {

    @Id
    private UUID id;
    private String name;
    private String phone;
    private String email;
    @ManyToOne
    private ReservableEntity reservableEntity;
    private int places;
    private LocalDate fromDate;
    private LocalDate toDate;

    protected Reservation() {}

    public Reservation(String name, String phone, String email, ReservableEntity reservableEntity, int places, LocalDate fromDate, LocalDate toDate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.reservableEntity = reservableEntity;
        this.places = places;
        this.fromDate = fromDate;
        this.toDate = toDate;
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (places != that.places) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (reservableEntity != null ? !reservableEntity.equals(that.reservableEntity) : that.reservableEntity != null)
            return false;
        if (fromDate != null ? !fromDate.equals(that.fromDate) : that.fromDate != null) return false;
        return toDate != null ? toDate.equals(that.toDate) : that.toDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (reservableEntity != null ? reservableEntity.hashCode() : 0);
        result = 31 * result + places;
        result = 31 * result + (fromDate != null ? fromDate.hashCode() : 0);
        result = 31 * result + (toDate != null ? toDate.hashCode() : 0);
        return result;
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
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
