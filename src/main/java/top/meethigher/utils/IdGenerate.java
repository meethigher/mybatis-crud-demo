package top.meethigher.utils;


/**
 * 封装各种生成唯一性ID算法的工具类.
 */
public class IdGenerate {
	private static IdWorker idWorker = new IdWorker(-1, -1);


	/**
	 * 获取新唯一编号（18为数值）
	 * 来自于twitter项目snowflake的id产生方案，全局唯一，时间有序。
	 * 64位ID (42(毫秒)+5(机器ID)+5(业务编码)+12(重复累加))
	 */
	public static String nextId() {
		return String.valueOf(idWorker.nextId());
	}

	/**
	 * 获取新唯一编号（18为数值）
	 * 来自于twitter项目snowflake的id产生方案，全局唯一，时间有序。
	 * 64位ID (42(毫秒)+5(机器ID)+5(业务编码)+12(重复累加))
	 */
	public static Long nextLongId() {
		return idWorker.nextId();
	}


}

