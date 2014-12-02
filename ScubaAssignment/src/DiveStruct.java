public class DiveStruct {
	private int diveNum;
	private int maxDepth;
	private int bottomTime;
	private int surfaceInterval;
	private int surfaceIntervalIndex;
	private int resNitrogen;

	public DiveStruct(){
	}
	public DiveStruct(int diveNum, int maxDepth, int bottomTime, int surfaceInterval, int resNitrogen, int surfaceIntervalIndex){
		this.diveNum = diveNum;
		this.maxDepth = maxDepth;
		this.bottomTime = bottomTime;
		this.surfaceInterval = surfaceInterval;
		this.surfaceIntervalIndex = surfaceIntervalIndex;
		this.resNitrogen = resNitrogen;
	}

	public void setDiveNum(int diveNum){
		this.diveNum = diveNum;
	}
	public void setMaxDepth(int maxDepth){
		this.maxDepth = maxDepth;
	}
	public void setBottomTime(int bottomTime){
		this.bottomTime = bottomTime;
	}
	public void setSurfaceInterval(int surfaceInterval){
		this.surfaceInterval = surfaceInterval;
	}
	public void setSurfaceIntervalIndex(int surfaceIntervalIndex){
		this.surfaceIntervalIndex = surfaceIntervalIndex;
	}

	public int getDiveNum(){
		return diveNum;
	}
	public int getMaxDepth(){
		return maxDepth;
	}
	public int getBottomTime(){
		return bottomTime;
	}
	public int getSurfaceInterval(){
		return surfaceInterval;
	}
	public int getSurfaceIntervalIndex(){
		return surfaceIntervalIndex;
	}
	public int getResNitrogen(){
		return resNitrogen;
	}
}
