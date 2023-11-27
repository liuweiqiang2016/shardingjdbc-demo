package com.zdxlz.lwq.ShardingAlgorithm;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;

public class CustomTableRule implements StandardShardingAlgorithm<Integer> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Integer> preciseShardingValue) {
        //collection返回数据库或数据表的集合，见yml配置的策略，此处返回的是数据表集合:[db1, db2]
        System.out.println("collection:"+collection.toString());
        //返回配置数据列的信息，包括列名、列值等，列名见yaml配置defaultDatabaseStrategy下的shardingColumn
        System.out.println("preciseShardingValue:"+preciseShardingValue.toString());
        //返回插入数据的列值
        int price=preciseShardingValue.getValue();
        System.out.println("price:"+price);
        //根据price进行自定义算法，分配table
        String table_name=setTableName(price);
        System.out.println("table_name:"+table_name);
        return table_name;
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Integer> rangeShardingValue) {

        System.out.println("collection:"+collection.toString());
        System.out.println("rangeShardingValue:"+rangeShardingValue.toString());
        return null;

    }

    public String setTableName(int price){
        //大于600存t_order_1
        if (price>600){
            return "t_order_1";
        }else {
            if (price>300){
                //大于300存t_order_2
                return "t_order_2";
            }
        }
        //小于300存t_order_3
        return "t_order_3";
    }
}
