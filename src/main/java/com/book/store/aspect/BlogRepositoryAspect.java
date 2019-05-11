package com.book.store.aspect;

import com.book.store.model.Blog;
import com.book.store.repository.BlogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

@Aspect
@Component
//@Order(1) for coherence of aspects
public class BlogRepositoryAspect {

    /*
     * THIS PART IS JUST FOR TESTING AOP!
     */


    /**
     * Before Advice for getAllBlogs prints just method signature
     *
     * @param joinPoint in order to get parameters
     */
    @Before("com.book.store.aspect.AopExpressions.forGetAllBlogs()")
    public void beforeGetAllBlogsAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature (@Before): " + signature.toShortString());
    }

    /**
     * After Advice for getAllBlogs prints just method signature
     *
     * @param joinPoint in order to get parameters
     */
    @After("com.book.store.aspect.AopExpressions.forGetAllBlogs()")
    public void afterGetAllBlogsAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature (@After): " + signature.toShortString());
    }

    /**
     * AfterReturning Advice for getAllBlogs prints returning data
     *
     * @param joinPoint in order to get parameters
     * @param blogs in order to get data which returns after success
     */
    @AfterReturning(pointcut = ("com.book.store.aspect.AopExpressions.forGetAllBlogs()"),
                    returning = ("blogs"))
    public void afterGetAllBlogsAdvice(JoinPoint joinPoint, List<Blog> blogs) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature (@AfterReturning):" + signature.toShortString());
        System.out.println("AfterReturning BlogRepository: " + blogs);
    }

    /**
     * AfterThrowing Advice for getAllBlogs prints throwing exception
     *
     * @param joinPoint in order to get parameters
     * @param exc in order to handle exception after throwing
     */
    @AfterThrowing(pointcut = ("com.book.store.aspect.AopExpressions.forGetAllBlogs()"),
                    throwing = ("exc"))
    public void afterThrowingGetAllBlogsAdvice(JoinPoint joinPoint, Throwable exc) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature (@AfterThrowing):" + signature.toShortString());
        exc.printStackTrace();
    }



}
