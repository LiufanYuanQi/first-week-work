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
     * @param id 需要查询的id
     * @return 查询的结果
     */
    String queryPositionByUserId(Long id);

    /**
     * 通过userid删除对应的所有职位
     * @param userId 需要删除的userid
     * @return 删除结果，成功为true
     */
    Boolean deletePosition(Long userId);

    /**
     * 通过userid更新职位
     * 如果user存在职位则更新
     * 如果不存在则插入一条
     * @param userId 更新的userid
     * @param positionId 更新的职位id
     * @return 是否更新成功
     */
    Boolean updatePosition(Long userId,Long positionId);

    /**
     * 初始化一个admin用户和admin职位，并绑定关系
     */
    void initUserAndPosition();
}
