package com.yrkim.apitest.repository.impl;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yrkim.apitest.model.entity.User;
import com.yrkim.apitest.repository.UserRepository;
import com.yrkim.apitest.repository.UserRepositoyCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static com.yrkim.apitest.model.entity.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoyCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<User> findByUserId(long id, Pageable pageable) {
        QueryResults<User> userQueryResults = jpaQueryFactory
                .selectFrom(user)
                .where(user.id.eq(id))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(userQueryResults.getResults(), pageable, userQueryResults.getTotal());
    }
}
