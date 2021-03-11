//還沒有用先註解起來
//package idv.example.demo.config;
//
//import java.lang.reflect.Method;
//import java.time.Duration;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisNode;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//@EnableCaching
//@RefreshScope
//public class RedisConfig extends CachingConfigurerSupport {
//
//	@Value("${FEIB.APIGW.OPENAPI2.redis.first.sentinel.host}")
//	private String redisFirstHost;
//
//	@Value("${FEIB.APIGW.OPENAPI2.redis.first.sentinel.port}")
//	private int redisFirstPort;
//
//	@Value("${FEIB.APIGW.OPENAPI2.redis.first.sentinel.password}")
//	private String redisFirstPwd;
//
//	@Value("${FEIB.APIGW.OPENAPI2.redis.second.sentinel.host}")
//	private String redisSecondHost;
//
//	@Value("${FEIB.APIGW.OPENAPI2.redis.second.sentinel.port}")
//	private int redisSecondPort;
//
//	@Value("${FEIB.APIGW.OPENAPI2.redis.second.sentinel.password}")
//	private String redisSecondPwd;
//
//	
//	@Bean
//	@Primary
//	public RedisTemplate<String, String> firstRedisTemplate(JedisConnectionFactory factory) throws Exception {
//		RedisSerializer stringSerializer = new StringRedisSerializer();
//		
// 		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//		redisTemplate.setConnectionFactory(factory);
//		redisTemplate.setKeySerializer(stringSerializer);
//		redisTemplate.setValueSerializer(stringSerializer);
//		redisTemplate.setHashKeySerializer(stringSerializer);
//		redisTemplate.setHashValueSerializer(stringSerializer);
//		return redisTemplate;
//	}
//	
//	@Bean("secondRedis")
//	public RedisTemplate<String, String>secondRedisTemplate(@Qualifier("secondFactory") JedisConnectionFactory factory) throws Exception {
//		RedisSerializer stringSerializer = new StringRedisSerializer();
//		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//		redisTemplate.setConnectionFactory(factory);
//		redisTemplate.setKeySerializer(stringSerializer);
//		redisTemplate.setValueSerializer(stringSerializer);
//		redisTemplate.setHashKeySerializer(stringSerializer);
//		redisTemplate.setHashValueSerializer(stringSerializer);
//		return redisTemplate;
//	}
//	
//	
//	public RedisSentinelConfiguration redisFirstSentinelConfiguration() {
//		RedisSentinelConfiguration config = new RedisSentinelConfiguration();
//		config.master("master");
//		Set<RedisNode> set =new HashSet<>();
//		set.add(new RedisNode(redisFirstHost, redisFirstPort));
//		config.setSentinels(set);
//		return config;
//	}
//	
//	public RedisSentinelConfiguration redisSecondSentinelConfiguration() {
//		RedisSentinelConfiguration config = new RedisSentinelConfiguration();
//		config.master("master");
//		Set<RedisNode> set =new HashSet<>();
//		set.add(new RedisNode(redisSecondHost, redisSecondPort));
//		config.setSentinels(set);
//		return config;
//	}
//	
//	@Bean
//	@Primary
//	public JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory factory = new JedisConnectionFactory(redisFirstSentinelConfiguration());
////		factory.setPassword("redis1234");
//		return factory;
//	}
//	
//	@Bean("secondFactory")
//	public JedisConnectionFactory jedisSecondConnectionFactory() {
//		JedisConnectionFactory factory = new JedisConnectionFactory(redisSecondSentinelConfiguration());
////		factory.setPassword("redis1234");
//		return factory;
//	}
//	
//	@Bean("wiselyKeyGenerator")
//	public KeyGenerator wiselyKeyGenerator() {
//		return new KeyGenerator() {
//
//			@Override
//			public Object generate(Object target, Method method, Object... params) {
//				// TODO Auto-generated method stub
//				StringBuilder sb = new StringBuilder();
//				sb.append(target.getClass().getName());
//				sb.append(method.getName());
//				for (Object obj : params) {
//					sb.append(obj.toString());
//				}
//				return sb.toString();
//			}
//		};
//	}
//}
