package hello.core.discount;

import hello.core.member.Member;

public interface Discountpolicy {

    // @return 할인 대상 금액
    // Fix, Rate가 구현클래스
    int discount(Member member, int price);
}
