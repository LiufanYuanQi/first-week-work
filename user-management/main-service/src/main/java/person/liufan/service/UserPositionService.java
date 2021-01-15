package person.liufan.service;

/**
 * @author liufan E-mail:fan.liu@biz-united.com.cn
 * @version 创建时间：2021/1/14
 *
 * 处理user和position对应关系
 */
public interface UserPositionService {
    /**
     * 通过userid查询对应的职位
     * @param id
     * @return
     */
    String queryPositionByUserId(Long id);

    /**
     * 通过userid删除对应的所有职位
     * @param userId
     * @return
     */
    Boolean deletePosition(Long userId);

    /**
     * 通过userid更新职位
     * 如果user存在职位则更新
     * 如果不存在则插入一条
     * @param userId
     * @param positionId
     * @return
     */
    Boolean updatePosition(Long userId,Long positionId);

    /**
     * 初始化一个admin用户和admin职位，并绑定关系
     */
    void initUserAndPosition();
}
