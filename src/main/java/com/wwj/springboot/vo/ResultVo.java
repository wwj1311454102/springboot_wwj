/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResultVo
 * Author:   13114
 * Date:     2019/8/15 10:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wwj.springboot.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 〈描述〉<br>
 * 〈〉
 *
 * @author 13114
 * @create 2019/8/15
 * @since 1.0.0
 */
@Data
@Component
public class ResultVo {
    private String code;
    private String message;
    private Map<String, Object> data;
}
