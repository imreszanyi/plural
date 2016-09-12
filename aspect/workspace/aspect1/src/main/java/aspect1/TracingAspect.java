package aspect1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.*;;


@Component
@Aspect
public class TracingAspect {

	boolean enteringCalled = false;
	
	public boolean isEnteringCalled() {
		return enteringCalled;
	}
	
	@Before("execution(void doSomething())")
	public void entering(JoinPoint joinPoint) {
		enteringCalled = true;
		System.out.println("entering" + joinPoint.getStaticPart().getSignature().toString());
	}
	
}
