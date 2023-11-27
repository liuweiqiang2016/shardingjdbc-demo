package com.zdxlz.lwq.ShardingAlgorithm;

import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.*;

public class ComplexRule implements ComplexKeysShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> collection, ComplexKeysShardingValue<Integer> complexKeysShardingValue) {
        //collection返回数据库或数据表的集合，见yml配置的策略，此处返回的是数据库集合:[db1, db2]
        Collection<String> shardingResults = new ArrayList<>();
        //返回数据表的key、value
        Map<String, Collection<Integer>> columnsMap = complexKeysShardingValue.getColumnNameAndShardingValuesMap();
        //columnsMap返回插入数据的key和value，key为complex中配置的shardingColumns字段值，此处返回为{user_id=[617]}
        List userIds = Arrays.asList(columnsMap.get("user_id").toArray());
        for (Object userId:userIds) {
            //对user_id进行逻辑处理
            int index = getIndex((Integer) userId);
            //循环匹配数据表源
            for (String availableTargetName : collection){
                if (availableTargetName.endsWith(String.valueOf(index))) {
                    shardingResults.add(availableTargetName);
                    break;
                }
            }
            //匹配到一种路由规则就可以退出
//            if (shardingResults.size() > 0) {
//                break;
//            }
        }
        //返回匹配到的数据库：shardingResults:[db_2]，数据表同理
        return shardingResults;
    }

    public int getIndex (int userId) {
        //大于500，存db1
        if (userId>500){
            return 1;
        }else {
            //小于500，存db2
            return 2;
        }
    }

}
