package com.yjh.vo;

import lombok.Data;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

/**
 * @Description
 * @ProjectName maintain-robot
 * @Package com.yjh.vo
 * @Author yangjh5
 * @CreateDate 2017/11/30
 */
@Data
public class CqpRespPrivMsg {

    private Boolean block = true;

    private String reply;

    private Boolean auto_escape = false;

}
