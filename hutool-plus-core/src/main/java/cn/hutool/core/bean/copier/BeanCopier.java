package cn.hutool.core.bean.copier;

import cn.hutool.core.bean.TargetProp;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.copier.Copier;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Bean拷贝，提供：
 *
 * <pre>
 *     1. Bean 转 Bean
 *     2. Bean 转 Map
 *     3. Map  转 Bean
 *     4. Map  转 Map
 * </pre>
 *
 * @author looly
 *
 * @param <S> 源对象类型
 * @param <T> 目标对象类型
 * @since 3.2.3
 */
public class BeanCopier<S, T> implements Copier<T>, Serializable {
	private static final long serialVersionUID = 1L;

	private final Copier<T> copier;

	/**
	 * 创建BeanCopier
	 *
	 * @param <S> 源对象类型
	 * @param <T> 目标Bean类型
	 * @param source 来源对象，可以是Bean或者Map
	 * @param target 目标Bean对象
	 * @param copyOptions 拷贝属性选项
	 * @return BeanCopier
	 */
	public static <S, T> BeanCopier<S, T> create(S source, T target, CopyOptions copyOptions) {
		return create(source, target, target.getClass(), copyOptions);
	}

	/**
	 * 创建BeanCopier
	 *
	 * @param <S> 源对象类型
	 * @param <T> 目标Bean类型
	 * @param source 来源对象，可以是Bean或者Map
	 * @param target 目标Bean对象
	 * @param beanCopyConsumer 属性拷贝函数
	 * @param copyOptions 拷贝属性选项
	 * @return BeanCopier
	 * @author lingengkeng
	 */
	public static <S, T> BeanCopier<S, T> create(S source, T target, BeanCopyConsumer<S, T> beanCopyConsumer, CopyOptions copyOptions) {
		return create(source, target, target.getClass(), beanCopyConsumer, copyOptions);
	}

	/**
	 * 创建BeanCopier
	 *
	 * @param <S> 源对象类型
	 * @param <T> 目标Bean类型
	 * @param source 来源对象，可以是Bean或者Map
	 * @param target 目标Bean对象
	 * @param destType 目标的泛型类型，用于标注有泛型参数的Bean对象
	 * @param beanCopyConsumer 属性拷贝函数
	 * @param copyOptions 拷贝属性选项
	 * @return BeanCopier
	 * @author lingengkeng
	 */
	public static <S, T> BeanCopier<S, T> create(S source, T target, Type destType, BeanCopyConsumer<S, T> beanCopyConsumer, CopyOptions copyOptions) {
		return new BeanCopier<>(source, target, destType, beanCopyConsumer, copyOptions);
	}

	/**
	 * 创建一个 BeanCopier 实例，用于拷贝数据源中的属性到目标 Bean 或 Map。
	 *
	 * @param source              来源对象，可以是实现了 Bean 接口的对象或 Map。
	 * @param target              目标 Bean 对象，可以是实现了 Bean 接口的对象或 Map。
	 * @param targetType          目标 Bean 的类型，用于类型转换。
	 * @param beanCopyConsumer    属性拷贝函数，用于定制拷贝行为。
	 * @param copyOptions         拷贝属性选项，用于控制拷贝过程中的行为。
	 * @throws IllegalArgumentException 如果 source 或 target 为 null，则抛出此异常。
	 * @author lingengkeng
	 */
	public BeanCopier(S source, T target, Type targetType, BeanCopyConsumer<S, T> beanCopyConsumer, CopyOptions copyOptions) {
		Assert.notNull(source, "Source bean must be not null!");
		Assert.notNull(target, "Target bean must be not null!");
		Copier<T> copier;
		if (source instanceof Map) {
			if (target instanceof Map) {
				//noinspection unchecked
				copier = (Copier<T>) new MapToMapCopier((Map<?, ?>) source, (Map<?, ?>) target, targetType, copyOptions);
			} else {
				copier = new MapToBeanCopier<>((Map<?, ?>) source, target, targetType, copyOptions);
			}
		}else if(source instanceof ValueProvider){
			//noinspection unchecked
			copier = new ValueProviderToBeanCopier<>((ValueProvider<String>) source, target, targetType, copyOptions);
		} else {
			if (target instanceof Map) {
				//noinspection unchecked
				copier = (Copier<T>) new BeanToMapCopier(source, (Map<?, ?>) target, targetType, copyOptions);
			} else {
				copier = new BeanToBeanCopier<>(source, target, targetType, beanCopyConsumer, copyOptions);
			}
		}
		this.copier = copier;
	}

	/**
	 * 创建BeanCopier
	 *
	 * @param <S> 源对象类型
	 * @param <T> 目标Bean类型
	 * @param source 来源对象，可以是Bean或者Map
	 * @param target 目标Bean对象
	 * @param destType 目标的泛型类型，用于标注有泛型参数的Bean对象
	 * @param copyOptions 拷贝属性选项
	 * @return BeanCopier
	 */
	public static <S, T> BeanCopier<S, T> create(S source, T target, Type destType, CopyOptions copyOptions) {
		return new BeanCopier<>(source, target, destType, copyOptions);
	}

	/**
	 * 构造
	 *
	 * @param source 来源对象，可以是Bean或者Map
	 * @param target 目标Bean对象
	 * @param targetType 目标的泛型类型，用于标注有泛型参数的Bean对象
	 * @param copyOptions 拷贝属性选项
	 */
	public BeanCopier(S source, T target, Type targetType, CopyOptions copyOptions) {
		Assert.notNull(source, "Source bean must be not null!");
		Assert.notNull(target, "Target bean must be not null!");
		Copier<T> copier;
		if (source instanceof Map) {
			if (target instanceof Map) {
				//noinspection unchecked
				copier = (Copier<T>) new MapToMapCopier((Map<?, ?>) source, (Map<?, ?>) target, targetType, copyOptions);
			} else {
				copier = new MapToBeanCopier<>((Map<?, ?>) source, target, targetType, copyOptions);
			}
		}else if(source instanceof ValueProvider){
			//noinspection unchecked
			copier = new ValueProviderToBeanCopier<>((ValueProvider<String>) source, target, targetType, copyOptions);
		} else {
			if (target instanceof Map) {
				//noinspection unchecked
				copier = (Copier<T>) new BeanToMapCopier(source, (Map<?, ?>) target, targetType, copyOptions);
			} else {
				copier = new BeanToBeanCopier<>(source, target, targetType, null, copyOptions);
			}
		}
		this.copier = copier;
	}

	@Override
	public T copy() {
		return copier.copy();
	}
}
