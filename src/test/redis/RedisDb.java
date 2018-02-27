package test.redis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;

public class RedisDb {
	
	public static RedisDb redisDb = null;
	
	private static Jedis jedis;//非切片额客户端连接
    private static JedisPool jedisPool;//非切片连接池
    private static ShardedJedis shardedJedis;//切片额客户端连接
    private static ShardedJedisPool shardedJedisPool;//切片连接池
    
    /**
     * 初始化非切片池
     */
    private void initialPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxIdle(20); 
        config.setMaxIdle(5); 
        config.setMaxWaitMillis(1000l); 
        config.setTestOnBorrow(false); 
        
        jedisPool = new JedisPool(config,"127.0.0.1",6379);
    }
    
    /** 
     * 初始化切片池 
     */ 
    private void initialShardedPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxIdle(20); 
        config.setMaxIdle(5); 
        config.setMaxWaitMillis(1000l); 
        config.setTestOnBorrow(false); 
        // slave链接 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo("127.0.0.1", 6379, "master")); 

        // 构造池 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    } 
	
	@SuppressWarnings("static-access")
	public RedisDb() throws Exception{
		initialPool(); 
        initialShardedPool(); 
        try {
        	this.setShardedJedis(shardedJedisPool.getResource());
            this.setJedis(jedisPool.getResource());
		} catch (Exception e) {
			throw new Exception("connect faild");
		}
        
	}

	public  static RedisDb getInstance(){
		if(redisDb == null){
			try {
				redisDb = new RedisDb();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return redisDb;
	}

	public static Jedis getJedis() {
		return jedis;
	}

	public static void setJedis(Jedis jedis) {
		RedisDb.jedis = jedis;
	}

	public static JedisPool getJedisPool() {
		return jedisPool;
	}

	public static void setJedisPool(JedisPool jedisPool) {
		RedisDb.jedisPool = jedisPool;
	}

	public static ShardedJedis getShardedJedis() {
		return shardedJedis;
	}

	public static void setShardedJedis(ShardedJedis shardedJedis) {
		RedisDb.shardedJedis = shardedJedis;
	}

	public static ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}

	public static void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		RedisDb.shardedJedisPool = shardedJedisPool;
	}
}
