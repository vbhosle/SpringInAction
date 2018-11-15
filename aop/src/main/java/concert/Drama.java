package concert;

import org.springframework.stereotype.Component;

@Component
public class Drama implements Performance {

	@Override
	public void perform() {
		System.out.println("Performing hamlet!");
	}

}
