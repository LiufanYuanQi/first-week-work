package person.liufan.service.entity;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/15
 * tb_position实体类，保存职位信息
 */
public class Position {
    /**
     * position的id
     */
    private Long id;
    /**
     * 具体职位
     */
    private String userPosition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }
}