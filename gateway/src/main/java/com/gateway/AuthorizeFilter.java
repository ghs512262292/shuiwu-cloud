//package com.shuiyou;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//
//@Order(-1) // 定义过滤器优先级，越小优先级越高
//@Component
//public class AuthorizeFilter implements GlobalFilter {
//
//    /**
//     *  处理当前请求，有必要的话通过{@link GatewayFilterChain} 将请求交给下一个过滤器处理
//     *
//     * @param exchange 请求上下文，里面可以过去Request、Response等信息
//     * @param chain 用来把请求委托给下一个过滤器
//     * @return 返回标识当前过滤器业务结束
//     */
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // 1.获取请求参数
//        ServerHttpRequest request = exchange.getRequest();
//        MultiValueMap<String, String> params = request.getQueryParams();
//        // 2.获取参数中的authorization参数
//        String auth = params.getFirst("authorization");
//        // 3.判断参数值是否等于 admin
//        if ("admin".equals(auth)) {
//            // 4.是，放行,去下一个过滤器
//            return chain.filter(exchange);
//        }
//
//        // 5.否，拦截
//        // 5.1.设置状态码
//        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED); // 枚举类型，未登录)
//        // 5.2.拦截请求
//        return exchange.getResponse().setComplete();
//
//    }
//}
// TODO 未来要做权限验证，现在不完全