package com.example.elasticsearch.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账号表
 * </p>
 *
 * @author xuliqun
 * @since 2020-09-03
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_account")
public class Account extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long personnelId;

    private String accountName;

    private String accountPhone;

    private String eMail;

    private String password;

    private Integer isForcePassword;


}
