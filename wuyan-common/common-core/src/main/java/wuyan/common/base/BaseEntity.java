package wuyan.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author sd-wangtaicheng@sdcncsi.com.cn
 * @date 2019/10/12
 */
@Data
public class BaseEntity implements Serializable {
	@ApiModelProperty("创建人")
	@TableField(
			fill = FieldFill.INSERT
	)
	private Long createBy;

	@ApiModelProperty("创建时间")
	@TableField(
			fill = FieldFill.INSERT
	)
	private LocalDateTime createTime;

	@ApiModelProperty("编辑人")
	@TableField(
			fill = FieldFill.INSERT_UPDATE
	)
	private Long updateBy;

	@ApiModelProperty("编辑时间")
	@TableField(
			fill = FieldFill.INSERT_UPDATE,
			update = "now()"
	)
	private LocalDateTime updateTime;

	@Version
	@ApiModelProperty("乐观锁")
	private Integer version;

	@ApiModelProperty("逻辑删除，1代表正常，0表示删除")
	private String deleteFlag = "1";
}
