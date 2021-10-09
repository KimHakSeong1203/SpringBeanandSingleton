package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member1 = new Member(1L, "member1", Grade.VIP);

        //when
        memberService.join(member1);
        Member findMember1 = memberService.findMember(member1.getId());

        //than
        Assertions.assertThat(member1).isEqualTo(findMember1);

    }
}
