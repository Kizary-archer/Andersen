package main.java.app.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "shuser", schema = "public", catalog = "Shop2")
public class UserEntity {
    private Integer iduser;
    private String login;
    private String password;
    private Integer type;
    private UserTypeEntity usertypeByType;
    private Collection<UserOrderEntity> userordersByIduser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser", nullable = false)
    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(iduser, that.iduser) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, login, password, type);
    }

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public UserTypeEntity getUsertypeByType() {
        return usertypeByType;
    }

    public void setUsertypeByType(UserTypeEntity usertypeByType) {
        this.usertypeByType = usertypeByType;
    }

    @OneToMany(mappedBy = "shuserByShuser")
    public Collection<UserOrderEntity> getUserordersByIduser() {
        return userordersByIduser;
    }

    public void setUserordersByIduser(Collection<UserOrderEntity> userordersByIduser) {
        this.userordersByIduser = userordersByIduser;
    }
}
