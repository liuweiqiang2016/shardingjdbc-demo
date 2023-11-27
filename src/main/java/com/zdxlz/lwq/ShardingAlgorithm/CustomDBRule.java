package com.zdxlz.lwq.ShardingAlgorithm;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.*;

public class CustomDBRule implements StandardShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Integer> preciseShardingValue) {
        //精准分片
        //collection返回数据库或数据表的集合，见yml配置的策略，此处返回的是数据库集合:[db1, db2]
        System.out.println("collection:"+collection.toString());
        //返回配置数据列的信息，包括列名、列值等，列名见yaml配置defaultDatabaseStrategy下的shardingColumn
        System.out.println("preciseShardingValue:"+preciseShardingValue.toString());
        //返回插入数据的列值
        int user_id=preciseShardingValue.getValue();
        System.out.println("user_id:"+user_id);
        //根据user_id进行自定义算法，分配db
        String db_name=setDBName(user_id);
        System.out.println("db_name:"+db_name);
        return db_name;
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Integer> rangeShardingValue) {

        //范围分片，未做深入研究
        System.out.println("collection:"+collection.toString());
        System.out.println("rangeShardingValue:"+rangeShardingValue.toString());
        return null;

    }

    public String setDBName(int userId){
        //大于500，存db_1
        if (userId>500){
            return "db_1";
        }else {
            //小于500，存db_2
            return "db_2";
        }
    }
}
