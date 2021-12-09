package com.yrkim.apitest.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
* @Configuration : 설정 클래스를 선언하는 어노테이션
* @Configuration + @Bean로 같이 사용됨
* 외부라이브러 또는 내장 클래스를 bean으로 등록하고자 할 경우 사용
* */
@Configuration
public class QuerydslConfiguration {

    // @PersistenceContext: 영속성 관리를 위해 존재하는 Entity Manager를
    // 스프링이 처음 시작할 때 빈으로 등록하는 어노테이션
    @PersistenceContext
    private EntityManager entityManager;

    // @Bean : bean을 정의하는 어노테이션
    @Bean
    public JPAQueryFactory jpaQueryFactory(){ return new JPAQueryFactory(entityManager); }
}
