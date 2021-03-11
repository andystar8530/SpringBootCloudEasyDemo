//還沒有用先註解起來
//package idv.example.demo.util;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//@Component(value = "RedisUtil")
//@RefreshScope
//public class RedisUtil {
//
//	private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);
//
//	@Autowired
//	RedisTemplate firstRedisTemplate;
//
//	@Autowired
//	@Qualifier("secondRedis")
//	RedisTemplate secondRedisTemplate;
//
//	public boolean set(String key, String value, long time) {
//		boolean isSave = false;
//		try {
//			if (key != null) {
//				firstRedisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);
//				isSave = true;
//			}
//		} catch (Exception ex) {
//			logger.error("first redis connection fail, check firstRedis 6379 connection and restart secondRedis 6380");
////			logger.error("redis set errorMsg: {}",ExceptionUtils.getStackTrace(ex));
//		}
//
//		try {
//			if (key != null) {
//				secondRedisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);
//				isSave = true;
//			}
//		} catch (Exception ex) {
//			logger.error("first redis connection fail, check secondRedis 6379 connection and restart firstRedis 6380");
//		}
//		return isSave;
//	}
//
//	public boolean set(String key, String value) {
//		boolean isSave = false;
//		try {
//			if (key != null) {
//				firstRedisTemplate.opsForValue().set(key, value);
//				isSave = true;
//			}
//		} catch (Exception ex) {
//			logger.error("first redis connection fail, check firstRedis 6379 connection and restart secondRedis 6380");
////			logger.error("redis set errorMsg: {}",ExceptionUtils.getStackTrace(ex));
//		}
//
//		try {
//			if (key != null) {
//				secondRedisTemplate.opsForValue().set(key, value);
//				isSave = true;
//			}
//		} catch (Exception ex) {
//			logger.error("first redis connection fail, check secondRedis 6379 connection and restart firstRedis 6380");
//		}
//		return isSave;
//	}
//
//	public String get(String key) throws Exception {
//		Object obj = null;
//		try {
//			obj = firstRedisTemplate.opsForValue().get(key);
//		} catch (Exception ex) {
//			logger.error(ExceptionUtils.getStackTrace(ex));
//		}
//		try {
//			if (obj == null) {
//				obj = secondRedisTemplate.opsForValue().get(key);
//			}
//			return (String) obj;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw new Exception("0601");
//		}
//	}
//
//	public boolean hset(String table, String key, String val) {
//		boolean isSave = false;
//		try {
//			firstRedisTemplate.opsForHash().put(table, key, val);
//			isSave = true;
//		} catch (Exception e) {
//			logger.error("first redis connection fail, check firstRedis 6379 connection and restart secondRedis 6380");
//		}
//
//		try {
//			secondRedisTemplate.opsForHash().put(table, key, val);
//			isSave = true;
//		} catch (Exception e) {
//			logger.error("first redis connection fail, check secondRedis 6379 connection and restart firstRedis 6380");
//		}
//		return isSave;
//	}
//	
//	public String hget(String table, String key) throws Exception {
//		Object obj = null;
//		try {
//			obj = firstRedisTemplate.opsForHash().get(table, key);
//		} catch (Exception ex) {
//			logger.error(ExceptionUtils.getStackTrace(ex));
//		}
//		try {
//			if (obj == null) {
//				obj = secondRedisTemplate.opsForHash().get(table, key);
//			}
//			return (String) obj;
//		} catch (Exception ex) {
//			logger.error(ExceptionUtils.getStackTrace(ex));
//			throw new Exception("0601");
//		}
//	}
//	
//	public List<String> hvals(String table) throws Exception {
//		List<String> dataList = null;
//		try {
//			dataList = firstRedisTemplate.opsForHash().values(table);
//		} catch (Exception ex) {
//			logger.error(ExceptionUtils.getStackTrace(ex));
//		}
//		try {
//			if (dataList == null) {
//				dataList = secondRedisTemplate.opsForHash().values(table);
//			}
//			return dataList;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw new Exception("0601");
//		}
//	}
//	
//	public long hlen(String table) throws Exception {
//		Object obj = null;
//		try {
//			obj = firstRedisTemplate.opsForHash().size(table);
//		} catch (Exception ex) {
//			logger.error(ExceptionUtils.getStackTrace(ex));
//		}
//		try {
//			if (obj == null) {
//				obj = secondRedisTemplate.opsForHash().size(table);
//			}
//			return (long) obj;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw new Exception("0601");
//		}
//	}
//
//	public boolean setExpire(String key, int expire) {
//		boolean isSave = false;
//		try {
//			firstRedisTemplate.expire(key, expire, TimeUnit.MINUTES);
//			isSave = true;
//		} catch (Exception e) {
//			logger.error("first redis connection fail, check firstRedis 6379 connection and restart secondRedis 6380");
//		}
//		
//		try {
//			secondRedisTemplate.expire(key, expire, TimeUnit.MINUTES);
//			isSave = true;
//		} catch (Exception e) {
//			logger.error("first redis connection fail, check secondRedis 6379 connection and restart firstRedis 6380");
//		}
//		return isSave;
//	}
//
//	public long incrby(String table, String key) throws Exception {
//		long obj = 0;
//		try {
//			obj = (long) firstRedisTemplate.opsForHash().increment(table, key, 1);
//		} catch (Exception ex) {
//			logger.error("first redis incr fail!");
//			logger.error("incrby Error Msg: {}", ExceptionUtils.getStackTrace(ex));
//		}
//		try {
//
//			obj = (long) secondRedisTemplate.opsForHash().increment(table, key, 1);
//
//		} catch (Exception ex) {
//			logger.error("second redis incr fail!");
//			logger.error("incrby Error Msg: {}", ExceptionUtils.getStackTrace(ex));
//		}
//		return (long) obj;
//	}
//
//	public boolean keyExeists(String key) throws Exception {
//		try {
//			if (firstRedisTemplate.hasKey(key)) {
//				return true;
//			}
//		} catch (Exception ex) {
//		}
//
//		try {
//			if (secondRedisTemplate.hasKey(key)) {
//				return true;
//			}
//		} catch (Exception ex) {
//			throw new Exception("0601");
//		}
//		return false;
//
//	}
//}
//
