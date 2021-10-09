package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // given
        Member member1 = new Member(1L, "memberVIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member1, 10000); // VIP 등급 회원이 만 원을 결제한다. 리턴 값 = 1,000
        // than
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인은 적용되지 않아야 한다")
    void vip_x() {
        // given
        Member member1 = new Member(2L, "memberVIP", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member1, 10000); // VIP 등급 회원이 만 원을 결제한다. 리턴 값 = 1,000
        // than
        assertThat(discount).isEqualTo(0);
    }

}