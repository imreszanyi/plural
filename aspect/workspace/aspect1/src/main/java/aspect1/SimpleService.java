package aspect1;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

	public void doSomething() {
		throw new RuntimeException("hello exception");
	}
	
	public void throwsRuntimeException() {
		throw new RuntimeException();
	}
}
