package aspect1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.*;;


@Component
@Aspect
public class TracingAspect {

	boolean enteringCalled = false;
	boolean exitingCalled = false;
	
	public boolean isEnteringCalled() {
		return enteringCalled;
	}
	
	public boolean isExitingCalled() {
		return exitingCalled;
	}

	@Before("execution(void doSomething())")
	public void entering(JoinPoint joinPoint) {
		enteringCalled = true;
		System.out.println("entering: " + joinPoint.getStaticPart().getSignature().toString());
	}
	
	@After("execution(void doSomething())")
	public void exiting(JoinPoint joinPoint) {
		exitingCalled = true;
		System.out.println("exiting: " + joinPoint.getStaticPart().getSignature().toString());
	}
	
	@After("execution(void throwsRuntimeException())")
	public void exitingThrows(JoinPoint joinPoint) {
		exitingCalled = true;
		System.out.println("exiting: " + joinPoint.getStaticPart().getSignature().toString());
	}
	
//	@AfterThrowing(pointcut = "execution(void doSomething())",throwing = "ex")
//	public void logException(RuntimeException ex) {
//		System.out.print("Exception: ");
//		System.out.println(ex.getMessage());
//	}
	
	
}
