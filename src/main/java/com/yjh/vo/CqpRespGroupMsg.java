package com.yjh.vo;

import lombok.Data;

/**
 * @Description
 * @ProjectName maintain-robot
 * @Package com.yjh.vo
 * @Author yangjh5
 * @CreateDate 2017/11/30
 */
@Data
public class CqpRespGroupMsg extends CqpRespDiscussMsg {

    // 撤回
    private Boolean delete;

    // 把发送者踢出群
    private Boolean kick;

    // 把发送者禁言
    private Boolean ban;

}
