package concert;

public class Circus implements Performance {

	@Override
	public void perform() throws PerformanceException {
		System.out.println("Taming lion....");
		System.out.println("Oops, lion attacked the ring master!");
		throw new PerformanceException();
	}

}
