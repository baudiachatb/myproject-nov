package b.com.project.authorizationserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Data
//@AllArgsConstructor
@Table(name = "user")
@Getter
public class User implements Serializable {
    public User() {
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.getEnabled();
        this.accountNonExpired = user.getAccountNonExpired();
        this.credentialsNonExpired = user.getCredentialsNonExpired();
        this.accountNonLocked = user.getAccountNonLocked();
        this.roles = user.getRoles();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;
    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;
    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    protected boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    protected boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    protected boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    protected boolean getEnabled() {
        return enabled;
    }
}

