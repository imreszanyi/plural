package aspect1;

import static org.junit.Assert.*;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/aspect1config.xml")
public class SimpleAspectXMLTest {

	@Autowired
	TracingAspect tracingAspect;
	
	@Autowired
	AroundAspect aroundAspect;
	
	@Autowired
	SimpleService simpleService;
	
	
	
	//@Ignore
	@Test
	public void testAspectEnteringIsCalled() {
		assertFalse(tracingAspect.isEnteringCalled());
		try {
			simpleService.doSomething();
		} catch (Exception e) {
			System.out.println("exception caught");
		}
		assertTrue(tracingAspect.isEnteringCalled());
	}
	
	@Ignore
	@Test
	public void testAspectExitingIsCalled() {
		assertFalse(tracingAspect.isExitingCalled());
		simpleService.doSomething();
		assertTrue(tracingAspect.isExitingCalled());
	}
	
	@Ignore
	@Test(expected = RuntimeException.class)
	public void testAspectExitingIsCalledThrowsException() {
		assertFalse(tracingAspect.isExitingCalled());
		try {
			simpleService.throwsRuntimeException();
		} finally {
			assertTrue(tracingAspect.isExitingCalled());
		}
	}
	
	
	
}
