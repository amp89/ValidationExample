package data;

import javax.annotation.PostConstruct;

public class DAO {

	private Person p;
	
	public DAO(){
		
	}
	
	@PostConstruct
	public void init(){
		
	}
	
	
	public Person getP(){
		
		return new Person("NAMEJELJD");
	}
	
	
}
