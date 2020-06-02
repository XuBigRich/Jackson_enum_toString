package piao888.top.jsonlist;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String  loginname;
    private String truename;
    private String nickname;
    private String loginPwd;
    private String qq;
    private String phone;
    private String email;
    private String remark;
    private String account_Non_Locked;



    private List roleList=new ArrayList();


    @Override
    public String toString() {
        return "User[" +
                "userID=" + userID +
                ", loginname='" + loginname + '\'' +
                ", truename='" + truename + '\'' +
                ", nickname='" + nickname + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", account_Non_Locked='" + account_Non_Locked + '\'' +
                ", roleList=" + roleList +
                ", roleid='" + roleid + '\'' +
                ", name='" + name + '\'' +
                ", show_name='" + show_name + '\'' +
                ", type='" + type + '\'' +
                ", telelephone='" + telelephone + '\'' +
                ", isDelete='" + isDelete + '\'' +
                ']';
    }





    public void setRoleList(List roleList) {
        this.roleList = roleList;
    }


    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShow_name() {
        return show_name;
    }

    public void setShow_name(String show_name) {
        this.show_name = show_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String roleid;
    private String name;
    private String show_name;
    private String type;

    private String telelephone;

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public List getRoleList() {
        return roleList;
    }
    private String isDelete;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAccount_Non_Locked() {
        return account_Non_Locked;
    }

    public void setAccount_Non_Locked(String account_Non_Locked) {
        this.account_Non_Locked = account_Non_Locked;
    }

    public String getTelelephone() {
        return telelephone;
    }

    public void setTelelephone(String telelephone) {
        this.telelephone = telelephone;
    }

}
