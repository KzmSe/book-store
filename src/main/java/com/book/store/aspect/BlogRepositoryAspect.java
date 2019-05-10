package com.book.store.aspect;

import com.book.store.model.Blog;
import com.book.store.repository.BlogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
//@Order(1) for coherence of aspects
public class BlogRepositoryAspect {

    /*
     * In order to test AOP
     */

    @Before("com.book.store.aspect.AopExpressions.forGetAllBlogs()")
    public void beforeGetAllBlogsAdvice(JoinPoint joinPoint) {
        System.out.println("Before BlogRepository");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature: " + signature);
    }

    @AfterReturning(pointcut = ("com.book.store.aspect.AopExpressions.forGetAllBlogs()"),
                    returning = ("blogs"))
    public void afterGetAllBlogsAdvice(List<Blog> blogs) {
        System.out.println("AfterReturning BlogRepository: " + blogs);
    }



}
