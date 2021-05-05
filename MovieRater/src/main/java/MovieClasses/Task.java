package MovieClasses;

import java.util.List;

public abstract class Task {
	
	protected List<String> params;

	public abstract boolean configure(List<String> params);
    public abstract String run();


}
