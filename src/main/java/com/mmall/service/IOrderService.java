package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

/**
 * Created by WangCH on 2018/2/12.
 */
public interface IOrderService {

    ServerResponse pay(Integer userId, String path, Long orderNo);

    ServerResponse aliCallback(Map<String,String> params);

    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);
}
