package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
  @Before("execution(* demo.ShoppingCart.checkout(..))")
  public void beforelogger(JoinPoint jp) {
	  System.out.println(jp.getSignature());
	  String arg=jp.getArgs()[0].toString();
	  System.out.println("before loggers:"+arg);
  }
  @After("execution(* *.*.checkout(..))")
  public void afterlogger() {
	  System.out.println("after loggers");
  }
  @Pointcut("within(* demo.ShoppingCart.quantity())")
  public void afterReturningPointCut() {
	  System.out.println("afterReturningPointCut");
  }
  
  @AfterReturning(pointcut = "afterReturningPointCut()",returning = "retVal")
  public void afterReturning(String retVal) {
	  System.out.println("after returning:"+retVal);
  }
}
