package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // 스프링 컨테이너 @Configuration 이 붙은 메소드를 호출함
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // AppConfig.MemberService
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member1 = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member1);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = "+order);
        System.out.println("price = "+order.calculatePrice());
    }
}