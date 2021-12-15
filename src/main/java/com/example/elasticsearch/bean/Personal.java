package com.example.elasticsearch.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * <p>
 * 人员表
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
@TableName("t_personal")
public class Personal extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private String phone;

    private String address;

    private String roleCode;

    private String roleName;

    private String gender;

    private Integer isEnable;

    private String accountName;

    private String cardNumber;

    private String appRole;

    private String loginTime;

    private Integer isLogin;

    private String servicePersonalGuid;

    private String weChatCode;

    private String weChatPic;

    private String weChatName;

}
