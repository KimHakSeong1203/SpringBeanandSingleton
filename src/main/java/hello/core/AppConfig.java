package hello.core;

import hello.core.discount.Discountpolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 애플리케이션의 설정 정보 스프링에 적용
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // 나중에 메모리 저장소에서 DB로 바뀌면 이 부분만 변경하면 됨
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountpolicy());
    }

    @Bean
    public Discountpolicy discountpolicy() {
        return new RateDiscountPolicy();      // 나중에 고정할인에서 비중할인(10%)로 바뀌면 이 부분만 변경하면 됨
    }
}
