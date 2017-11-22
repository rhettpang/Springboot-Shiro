package com.test.shiro.redis;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Set;

/**
 *@author  Created by Administrator on 2017/11/20.
 */
@Component
public class RedisUtils {

    @Resource
    protected HashOperations<String,String,Object> hashOperations;

    @Resource
    protected RedisTemplate<String,Object> redisTemplate;

    @Resource
    protected ValueOperations<String, Object> valueOperations;


    /**
     * 查询key,支持模糊查询
     *
     * @param key 传过来时key的前后端已经加入了*，或者根据具体处理
     * */
    public Set<String> keys(String key){

        return redisTemplate.keys(key);
    }

    /**
     * 重命名key
     * */
    public void renameKey(String key,String newKey){
        redisTemplate.rename(key,newKey);
    }

    /**
     *字符串添加信息
     * @param key
     * @param obj 可以是单个的值，也可以是任意类型的对象
     * */
    public void set(String key,Object obj){
        valueOperations.set(key,obj);
    }

    /**
     * 字符串获取值
     * @param key
     * */
    public Object get(String key){
       return valueOperations.get(key);
    }

    /**
     * 删出key
     * 这里跟下边deleteKey（）最底层实现都是一样的，应该可以通用
     * @param key
     * */
    public void delete(String key){
        valueOperations.getOperations().delete(key);
    }

    /**
     * 添加单个
     *
     * @param key    key
     * @param filed  filed
     * @param domain 对象
     */
    public void hset(String key,String filed,Object domain){
        hashOperations.put(key, filed, domain);
    }


    /**
     * 添加HashMap
     *
     * @param key    key
     * @param hm    要存入的hash表
     */
    public void hset(String key, HashMap<String,Object> hm){
        hashOperations.putAll(key,hm);
    }

    /**
     * 查询key和field所确定的值
     *
     * @param key 查询的key
     * @param field 查询的field
     * @return HV
     */
    public Object hget(String key,String field) {
        return hashOperations.get(key, field);
    }

    /**
     * 查询该key下所有值
     *
     * @param key 查询的key
     * @return Map<HK, HV>
     */
    public Object hget(String key) {
        return hashOperations.entries(key);
    }

    /**
     * 删除key下所有值
     *
     * @param key 查询的key
     */
    public void deleteKey(String key) {
        hashOperations.getOperations().delete(key);
    }

    /**
     * 判断key和field下是否有值
     *
     * @param key 判断的key
     * @param field 判断的field
     */
    public Boolean hasKey(String key,String field) {
        return hashOperations.hasKey(key,field);
    }

    /**
     * 判断key下是否有值
     *
     * @param key 判断的key
     */
    public Boolean hasKey(String key) {
        return hashOperations.getOperations().hasKey(key);
    }
}
