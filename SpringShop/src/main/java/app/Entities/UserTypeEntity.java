package main.java.app.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usertype", schema = "public", catalog = "Shop2")
public class UserTypeEntity {
    private Integer id;
    private String nametype;
    private Collection<UserEntity> shusersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nametype", nullable = false, length = 50)
    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nametype) {
        this.nametype = nametype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTypeEntity that = (UserTypeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nametype, that.nametype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nametype);
    }

    @OneToMany(mappedBy = "usertypeByType")
    public Collection<UserEntity> getShusersById() {
        return shusersById;
    }

    public void setShusersById(Collection<UserEntity> shusersById) {
        this.shusersById = shusersById;
    }
}
