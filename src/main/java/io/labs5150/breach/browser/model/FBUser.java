
package io.labs5150.breach.browser.model;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FBUser.findAll", query = "SELECT f FROM FBUser f"),
    @NamedQuery(name = "FBUser.findById", query = "SELECT f FROM FBUser f WHERE f.id = :id"),
    @NamedQuery(name = "FBUser.findByFirstName", query = "SELECT f FROM FBUser f WHERE f.firstName = :firstName"),
    @NamedQuery(name = "FBUser.findByLastName", query = "SELECT f FROM FBUser f WHERE f.lastName = :lastName"),
    @NamedQuery(name = "FBUser.findByGender", query = "SELECT f FROM FBUser f WHERE f.gender = :gender"),
    @NamedQuery(name = "FBUser.findByCurrentCity", query = "SELECT f FROM FBUser f WHERE f.currentCity = :currentCity"),
    @NamedQuery(name = "FBUser.findByCurrentState", query = "SELECT f FROM FBUser f WHERE f.currentState = :currentState"),
    @NamedQuery(name = "FBUser.findByCurrentCountry", query = "SELECT f FROM FBUser f WHERE f.currentCountry = :currentCountry"),
    @NamedQuery(name = "FBUser.findByBirthCity", query = "SELECT f FROM FBUser f WHERE f.birthCity = :birthCity"),
    @NamedQuery(name = "FBUser.findByBirthState", query = "SELECT f FROM FBUser f WHERE f.birthState = :birthState"),
    @NamedQuery(name = "FBUser.findByBirthCountry", query = "SELECT f FROM FBUser f WHERE f.birthCountry = :birthCountry"),
    @NamedQuery(name = "FBUser.findByRelationshipStatus", query = "SELECT f FROM FBUser f WHERE f.relationshipStatus = :relationshipStatus"),
    @NamedQuery(name = "FBUser.findByOccupancy", query = "SELECT f FROM FBUser f WHERE f.occupancy = :occupancy"),
    @NamedQuery(name = "FBUser.findByAccountCreated", query = "SELECT f FROM FBUser f WHERE f.accountCreated = :accountCreated"),
    @NamedQuery(name = "FBUser.findByEmail", query = "SELECT f FROM FBUser f WHERE f.email = :email"),
    @NamedQuery(name = "FBUser.findByBirthDate", query = "SELECT f FROM FBUser f WHERE f.birthDate = :birthDate"),
    @NamedQuery(name = "FBUser.findByFirstNameContaining", query = "SELECT f FROM FBUser f WHERE f.firstName LIKE :firstName"),
    @NamedQuery(name = "FBUser.findByLastNameContaining", query = "SELECT f FROM FBUser f WHERE f.lastName LIKE :lastName")})

public class FBUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "currentCity")
    private String currentCity;
    @Column(name = "currentState")
    private String currentState;
    @Column(name = "currentCountry")
    private String currentCountry;
    @Column(name = "birthCity")
    private String birthCity;
    @Column(name = "birthState")
    private String birthState;
    @Column(name = "birthCountry")
    private String birthCountry;
    @Column(name = "relationshipStatus")
    private String relationshipStatus;
    @Column(name = "occupancy")
    private String occupancy;
    @Column(name = "accountCreated")
    private String accountCreated;
    @Column(name = "email")
    private String email;
    @Column(name = "birthDate")
    private String birthDate;
    private static final Logger logger = LoggerFactory.getLogger(FBUser.class);

    public FBUser() {
    }

    public FBUser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getCurrentCountry() {
        return currentCountry;
    }

    public void setCurrentCountry(String currentCountry) {
        this.currentCountry = currentCountry;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public String getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(String accountCreated) {
        this.accountCreated = accountCreated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FBUser)) {
            return false;
        }
        FBUser other = (FBUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.labs5150.breach.browser.model.FBUser[ id=" + id + " ]";
    }


}
