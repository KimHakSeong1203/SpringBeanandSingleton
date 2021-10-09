package hello.core.beanfind;

import hello.core.discount.Discountpolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면 중복 오류가 발생한다.")
    void findBeanByParentTypeDuplication() {
        Discountpolicy bean = ac.getBean(Discountpolicy.class);
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(Discountpolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상 있으면 중복 오류가 발생한다.")
    void findBeanByParentTypeBeanName() {
        Discountpolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", Discountpolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(Discountpolicy.class);
    }

    @Configuration
    static class TestConfig {
        @Bean
        public Discountpolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        public Discountpolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
