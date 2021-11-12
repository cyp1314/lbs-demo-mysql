package com.chen.app;

import com.alibaba.fastjson.JSON;
import com.chen.app.entity.UserEntity;
import com.chen.app.util.LbsUtil;
import com.spatial4j.core.shape.Rectangle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        List<UserEntity> users = new ArrayList<>();
        users.add(new UserEntity(1,"a",116.504874,39.982296,new Date()));  //
        users.add(new UserEntity(2,"b",116.503976,39.980067,new Date()));
        users.add(new UserEntity(3,"c",116.494167,39.977272,new Date()));
        users.add(new UserEntity(4,"d",116.496538,39.976975,new Date()));

        App app = new App();
        String s = app.nearBySearch(0.5, 116.503491, 39.982037, users);
        System.out.println(s);

    }


    /**
     * 获取附近 x 米的人
     *
     * @param distance 搜索距离范围 单位km
     * @param userLng  当前用户的经度
     * @param userLat  当前用户的纬度
     */
    public String nearBySearch(double distance, double userLng, double userLat,List<UserEntity> users) {
        LbsUtil lbsUtil = new LbsUtil();
        //1.获取外接正方形
        Rectangle rectangle = lbsUtil.getRectangle(distance, userLng, userLat);

        /**
         *
         *
         * SELECT * FROM nearby_user
         * WHERE 1=1
         * AND (longitude BETWEEN #{minlng} AND #{maxlng})
         * AND (latitude BETWEEN #{minlat} AND #{maxlat})
         *
         */

        //2.获取位置在正方形内的所有用户
//        List<User> users = userMapper.selectUser(rectangle.getMinX(), rectangle.getMaxX(), rectangle.getMinY(), rectangle.getMaxY());
//        //3.剔除半径超过指定距离的多余用户
        users = users.stream()
                .filter(a -> lbsUtil.getDistance(a.getLongitude(), a.getLatitude(), userLng, userLat) <= distance)
                .collect(Collectors.toList());
        return JSON.toJSONString(users);

    }
}
