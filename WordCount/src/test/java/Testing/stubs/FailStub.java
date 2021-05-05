package Testing.stubs;

import Test.WordCounter;

public class FailStub extends WordCounter{
	
	@Override
	public String run(){
		return "An error has occured.";
	}
}
