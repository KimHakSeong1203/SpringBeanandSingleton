package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // @Bean 관리 || 스프링 컨테이너
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // AppConfig.MemberService
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Member member1 = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member1);
        Member findMember1 = memberService.findMember(1L);

        System.out.println("create member = "+ member1.getName());
        System.out.println("find member = "+ findMember1.getName());
    }
}
