package ssm.model;

import java.util.Date;

/**
 * Created by jzy on 2017/8/27.
 */
public class User {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String salt;
    private int frozen;
    private String email;
    private int role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getFrozen() {
        return frozen;
    }

    public void setFrozen(int frozen) {
        this.frozen = frozen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getForgetCode() {
        return forgetCode;
    }

    public void setForgetCode(String forgetCode) {
        this.forgetCode = forgetCode;
    }

    public Date getForgetDuration() {
        return forgetDuration;
    }

    public void setForgetDuration(Date forgetDuration) {
        this.forgetDuration = forgetDuration;
    }

    private String forgetCode;
    private Date forgetDuration;
}
