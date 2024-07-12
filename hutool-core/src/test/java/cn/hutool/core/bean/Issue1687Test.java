package cn.hutool.core.bean;

import cn.hutool.core.annotation.Alias;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.map.MapUtil;
import lombok.Data;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * https://github.com/dromara/hutool/issues/1687
 */
public class Issue1687Test {

	@Test
	public void toBeanTest(){
		final SysUserFb sysUserFb = new SysUserFb();
		sysUserFb.setDepId("123");
		sysUserFb.setCustomerId("456");

		final SysUser sysUser = BeanUtil.toBean(sysUserFb, SysUser.class);
		// 别名错位导致找不到字段
		Assert.assertNull(sysUser.getDepart());
		Assert.assertEquals(new Double(456D), sysUser.getOrgId());
	}

	@Test
	public void toBeanTest1(){
		final SysUserFb sysUserFb = new SysUserFb();
		sysUserFb.setDepId("123");
		sysUserFb.setCustomerId("456");
		sysUserFb.setValue(1d);

		// 对象属性值转换
		final SysUser sysUser = BeanUtil.toBean(sysUserFb, SysUser.class, (targetProp, source, target, sourceValue) -> {
			// 相同属性不同类型：把属性值进行逻辑运算，并赋值给目标属性
//			targetProp.set(source::getValue, target::getValue, Double.valueOf(sourceValue.toString()) + 1);
			targetProp.set(source::getValue, target::getValue, sourceValue.toString() + "kg/㎡");
			// 不同属性，不同类型：直接赋值给目标属性
			targetProp.set(source::getCustomerId, target::getOrgId, sourceValue);
        });

		Assert.assertNull(sysUser.getDepart());
		Assert.assertEquals(Double.valueOf(sysUserFb.getCustomerId()), sysUser.getOrgId());
	}

	@Test
	public void copyToListTest(){
		final SysUserFb sysUserFb = new SysUserFb();
		sysUserFb.setDepId("123");
		sysUserFb.setCustomerId("456");
		sysUserFb.setValue(1d);

		List<SysUserFb> sysUserFbList = Arrays.asList(sysUserFb);
		// 列表中的对象属性值转换
		List<SysUser> sysUsers = BeanUtil.copyToList(sysUserFbList, SysUser.class, (targetProp, source, target, sourceValue) -> {
			// 不同属性，不同类型：直接赋值给目标属性
			targetProp.set(source::getCustomerId, target::getOrgId, sourceValue);
			// 相同属性不同类型：把属性值进行逻辑运算，并赋值给目标属性
			targetProp.set(source::getValue, target::getValue, Double.valueOf(sourceValue.toString()) + 1);
		});

		Assert.assertEquals(Double.valueOf(sysUserFb.getCustomerId()), sysUsers.get(0).getOrgId());
	}

	@Test
	public void toBeanTest2(){
		final SysUserFb sysUserFb = new SysUserFb();
		sysUserFb.setDepId("123");
		sysUserFb.setCustomerId("456");

		// 补救别名错位
		final CopyOptions copyOptions = CopyOptions.create().setFieldMapping(
				MapUtil.builder("depart", "depId").build()
		);
		final SysUser sysUser = BeanUtil.toBean(sysUserFb, SysUser.class, copyOptions);

		Assert.assertEquals(new Long(123L), sysUser.getDepart());
		Assert.assertEquals(new Double(456D), sysUser.getOrgId());
	}

	@Data
	static class SysUserFb implements Serializable {

		private static final long serialVersionUID = 1L;

		@Alias("depart")
		private String depId;

		@Alias("orgId")
		private String customerId;

		/**
		 * 估值
		 */
		@Alias("value")
		private Double value;
	}

	@Data
	@Setter
	static class SysUser implements Serializable {

		private static final long serialVersionUID = 1L;

		@Alias("depId")
		private Long depart;

		private Double orgId;

		/**
		 * 估值
		 */
		@Alias("value")
		private String value;
	}
}
