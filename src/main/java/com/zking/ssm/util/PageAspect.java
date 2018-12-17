package com.zking.ssm.util;

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

    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {

        Object[] params = args.getArgs();
        PageBean pageBean=null;

        for (Object param : params) {
            if(param instanceof PageBean){
                pageBean=(PageBean)param;
                break;
            }
        }

        //设置分页参数
        if (null!=pageBean&&pageBean.isPagination())
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());

        //执行方法，设置方法参数
        Object result = args.proceed(params);

        //将分页的总记录数设置到PageBean中
        if (null!=pageBean&&pageBean.isPagination()){
            List list=(List)result;
            PageInfo pageInfo=new PageInfo(list);
            pageBean.setTotal(pageInfo.getTotal()+"");
            System.out.println(pageInfo.getTotal());
            System.out.println("总记录数："+pageBean.getTotal());
        }
        return result;
    }
}
