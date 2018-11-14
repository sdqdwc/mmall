package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author WangCH
 * @create 2018-02-07 22:15
 */
public class Const {

    //当前登录用户
    public static final String CURRENT_USER = "currentUser";

    //邮箱
    public static final String EMAIL = "email";

    //用户名
    public static final String USERNAME = "username";

    //产品排序
    public interface ProductListOrderBy{
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc","price_asc");
    }

    //购物车
    public interface Cart{
        int CHECKED = 1;//即购物车选中状态
        int UN_CHECKED = 0;//购物车中未选中状态
        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS";
    }

    //角色权限
    public interface Role{
        int ROLE_CUSTOMER = 0;//普通用户
        int ROLE_ADMIN = 1;//管理员
    }

    //产品状态枚举
    public enum ProductStatusEnum{
        ON_SALE(1, "在线");
        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        ProductStatusEnum(int code, String value){
            this.code = code;
            this.value = value;
        }
    }

    //订单状态
    public enum OrderStatusEnum{
        CANCELED(0,"已取消"),
        NO_PAY(10,"未支付"),
        PAID(20,"已支付"),
        SHIPPED(40,"已发货"),
        ORDER_SUCCESS(50,"订单完成"),
        ORDER_CLOSE(60,"订单关闭");

        private String value;
        private int code;
        public String getValue(){
            return value;
        }
        public int getCode(){
            return code;
        }
        OrderStatusEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        public static OrderStatusEnum codeOf(int code){
            for(OrderStatusEnum orderStatusEnum :values()){
                if(orderStatusEnum.getCode() == code){
                    return orderStatusEnum;
                }
            }
            throw  new RuntimeException("没有找到对应的枚举");
        }
    }

    //支付宝回调状态
    public interface AlipayCallback{
        String TRADE_STATUS_WAIT_BUYER_PAY="WAIT_BUYER_PAY";//交易创建，等待买家付款

        String TRADE_STATUS_TRADE_SUCCESS="TRADE_SUCCESS";//支付成功

        //String TRADE_STATUS_TRADE_CLOSED="TRADE_CLOSED";//未付款交易超时关闭，或支付完成后全额退款
        //String TRADE_STATUS_TRADE_CLOSED="TRADE_CLOSED";//交易关闭

        String RESPONSE_SUCCESS = "success";

        String TRESPONSE_FAILED = "failed";
    }

    public enum PayPlatformEnum{
        ALIPAY(1,"支付宝");

        private String value;
        private int code;
        public String getValue(){
            return value;
        }
        public int getCode(){
            return code;
        }
        PayPlatformEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
    }

    public enum PaymentTypeEnum{
        ONLINE_PAY(1,"在线支付");

        private String value;
        private int code;
        public String getValue(){
            return value;
        }
        public int getCode(){
            return code;
        }
        PaymentTypeEnum(int code,String value){
            this.code = code;
            this.value = value;
        }
        public static PaymentTypeEnum codeOf(int code){
            for(PaymentTypeEnum paymentTypeEnum :values()){
                if(paymentTypeEnum.getCode() == code){
                    return paymentTypeEnum;
                }
            }
            throw  new RuntimeException("没有找到对应的枚举");
        }
    }

}
