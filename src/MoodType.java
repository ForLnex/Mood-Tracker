import java.util.ArrayList;
import java.util.List;

public enum MoodType {
	//Right now I'm just using index, but that's not very change-friendly, and will break old saves if we mess with ordering at all.
	SOCIAL("Isolate", "Partner only", "Close friends", "Anyone", "Party"),
	ACTIVE("No energy", "Numbing activity", "Video games", "Programming", "Exercise"),
	RESPONSIBILE("No self care", "Basic self care", "Cleaning", "Shopping");
	
	private List<String> moodValues;
	
	MoodType(String... values){
		this.moodValues = new ArrayList<String>();
		for(String value : values){
			this.moodValues.add(value);
		}
	}
	
	public List<String> getMoodValues(){
		return this.moodValues;
	}
	
	public String toString(){
		return this.name().toLowerCase();
	}
}
