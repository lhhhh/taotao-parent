package some;

public abstract class Bird {
	protected String name = "bird.name";

	abstract String getName();
	
	public void setName(String name){
		this.name = name;
	}
}
