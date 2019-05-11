package com.book.store.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.book.store.repository.*.get*(..))")
    void getter() {}

    @Pointcut("execution(* com.book.store.repository.*.set*(..))")
    void setter() {}

    @Pointcut("execution(* com.book.store.repository.BlogRepository.getAllBlogs())")
    void forGetAllBlogs() {}

    @Pointcut("execution(* com.book.store.repository.BlogRepository.*(..))")
    void forBlogRepository() {}

    @Pointcut("forBlogRepository() && !(getter() || setter())")
    void forBlogRepositoryNoGetterAndSetter() {}

}
