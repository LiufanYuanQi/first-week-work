package person.liufan.service.vo;

import java.util.Date;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/14
 *
 * 用于UserDetail页面的展示
 */
public class UserDetailVO {
    private Long id;

    private String userName;

    private String userEmail;

    private String userProvinceAndCity;

    private String createTime;

    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserProvinceAndCity() {
        return userProvinceAndCity;
    }

    public void setUserProvinceAndCity(String userProvinceAndCity) {
        this.userProvinceAndCity = userProvinceAndCity;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "UserDetailVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userProvinceAndCity='" + userProvinceAndCity + '\'' +
                ", createTime='" + createTime + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
