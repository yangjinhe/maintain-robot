package com.yjh.vo;

import lombok.Data;

import java.util.Map;

/**
 * @Description
 * @ProjectName maintain-robot
 * @Package com.yjh.vo
 * @Author yangjh5
 * @CreateDate 2017/12/2
 */
@Data
public class CqpHttpApiResp {

    private int retcode;

    private String status;

    private Map<String, Object> data;

}
