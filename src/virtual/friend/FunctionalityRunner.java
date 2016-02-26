package virtual.friend;

import java.util.ArrayList;

public abstract class FunctionalityRunner {
	
	protected static String NODATA = "No data";
	protected ConsoleBox console;
	private int nextElementIndex = 0;
	
	protected ArrayList<String> data;
	protected ArrayList<String []> arrayData;
	
	
	public FunctionalityRunner(ConsoleBox box) {
		this.console = box;
	}
	
	public abstract void next();
	
	public boolean hasNextElement(){
		if (data == null && arrayData == null)
			return false;
		
		if (data == null && arrayData.size() == 0)
			return false;
		
		if (arrayData == null && data.size() == 0)
			return false;
		
		return true;
	}
	
	protected int getNextElementIndex(){
		nextElementIndex++;
		if (nextElementIndex >= (data!=null?data.size():(arrayData!=null?arrayData.size():0))) {
			nextElementIndex = 0;
		}
		return nextElementIndex;
	}
	
	public void setData(ArrayList<String> list){
		//TODO extend if needed
	};
	
	public void setDataArrays(ArrayList<String []> list){
		arrayData = list;
	};
	
}
