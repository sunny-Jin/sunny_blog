package ssm.model;

import java.util.Date;

/**
 * Created by jzy on 2017/8/27.
 */
public class User {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getFrozen() {
        return frozen;
    }

    public void setFrozen(byte frozen) {
        this.frozen = frozen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
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

    private String userName;
    private String password;
    private String nickName;
    private String salt;
    private byte frozen;
    private String email;
    private byte role;
    private String forgetCode;
    private Date forgetDuration;
}
