package com.atguigu.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/18 22:57
 */
@Configuration
public class GateWayConfig {

    /** 代码配置路由 */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r-> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .route("path_route_atguigu",
                        r-> r.path("/guoji")
                                .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
