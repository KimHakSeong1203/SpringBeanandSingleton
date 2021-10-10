package hello.core.order;

import hello.core.discount.Discountpolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final Discountpolicy discountpolicy;

    public OrderServiceImpl(MemberRepository memberRepository, Discountpolicy discountpolicy) {
        this.memberRepository = memberRepository;
        this.discountpolicy = discountpolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 주문 생성 요청이 오면 회원 정보를 조회 한 후
        Member member = memberRepository.findById(memberId);

        // 회원 정책에 회원 정보를 넘김
        int discointPrice = discountpolicy.discount(member, itemPrice);

        // 회원
        return new Order(memberId, itemName, itemPrice, discointPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
