package com.yangkw.pin.api;

import com.yangkw.pin.domain.BaseResponse;
import com.yangkw.pin.domain.order.Order;
import com.yangkw.pin.domain.request.AdviceOrderRequest;
import com.yangkw.pin.domain.request.FuzzyOrderRequest;
import com.yangkw.pin.domain.request.OrderRequest;
import com.yangkw.pin.domain.request.OwnOrderRequest;
import com.yangkw.pin.domain.request.PartnerOrderRequest;
import com.yangkw.pin.domain.request.PublishOrderRequest;
import com.yangkw.pin.service.CacheService;
import com.yangkw.pin.service.OrderService;
import com.yangkw.pin.service.annotation.ParamCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 类TripController.java的实现描述：TODO
 *
 * @author kaiwen.ykw 2018-12-26
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CacheService cacheService;

    @PostMapping("fuzzy")
    @ParamCheck
    public BaseResponse fuzzy(@RequestBody @Validated FuzzyOrderRequest request, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        List<Order> orderList = orderService.findOrderList(request);
        response.setSuccess(true);
        response.setData(orderList);
        return response;
    }

    @PostMapping("own")
    @ParamCheck
    public BaseResponse own(@RequestBody @Validated OwnOrderRequest request, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        List<Order> orderList = orderService.findOwnOrderList(request.getToken());
        response.setData(orderList);
        response.setSuccess(true);
        return response;
    }

    @PostMapping("publish")
    @ParamCheck
    public BaseResponse publish(@RequestBody @Validated PublishOrderRequest request, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(orderService.publish(request));
        return response;
    }

    @PostMapping("query")
    @ParamCheck
    public BaseResponse query(@RequestBody @Validated OrderRequest request, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        Integer userId = cacheService.getUserId(request.getToken());
        response.setData(orderService.findOrder(request.getOrderId(), userId));
        response.setSuccess(true);
        return response;
    }

    @PostMapping("join")
    @ParamCheck
    public BaseResponse query(@RequestBody @Validated PartnerOrderRequest request, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(orderService.join(request));
        return response;
    }

    @PostMapping("cancel")
    @ParamCheck
    public BaseResponse cancel(@RequestBody @Validated PartnerOrderRequest request, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        orderService.cancel(request);
        response.setSuccess(true);
        return response;
    }

    @PostMapping("advice")
    @ParamCheck
    public BaseResponse advice(@RequestBody @Validated AdviceOrderRequest request, BindingResult bindingResult) {
        BaseResponse response = new BaseResponse();
        response.setData(orderService.adviceOrderS(request));
        response.setSuccess(true);
        return response;
    }

}
