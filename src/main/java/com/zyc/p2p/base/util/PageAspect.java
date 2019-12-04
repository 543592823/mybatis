package com.zyc.p2p.base.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {

    @Around(value = "execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取目标方法的执行参数
        Object[] args = joinPoint.getArgs();
        //定义PageBean对象
        PageBean pageBean = null;
        //循环遍历参数
        for (Object arg : args) {
            if (arg instanceof PageBean) {
                pageBean = (PageBean) arg;
                break;
            }
        }
        Object result =null;
        //判断是否分页，并且设置分页参数到PageHeloer中
        if (null != pageBean && pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
            //执行目标方法
            result = joinPoint.proceed(args);
            //获取分页信息
            if (null != pageBean && pageBean.isPagination() && null != result && result instanceof List) {
                List lst = (List) result;
                PageInfo pageInfo = new PageInfo(lst);
                pageBean.setTotal(pageInfo.getTotal()+"");
            }
        }
        return result;
    }
}
