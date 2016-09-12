package aspect1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {

//	@Pointcut("execution(void doSomething())")
//	void throwableMethod() { }
	
	//@Around("throwableMethod()") 
	@Around("execution(void doSomething())")
	public void swallowThrowing(ProceedingJoinPoint pjp) {
		try {
			pjp.proceed();
		} catch (Throwable e) {
			System.out.println("swallow: " + e.toString());
		}
	}
	
}
