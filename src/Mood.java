
public class Mood {
	public static final String DELIMITER = ":";
	private MoodType type;
	private Integer value;
	
	public Mood(MoodType type, Integer value){
		this.type = type;
		this.value = value;
	}
	
	public MoodType getMoodType(){
		return this.type;
	}
	
	public Integer getMoodValue(){
		return this.value;
	}
	
	public String toString(){
		return this.type.toString() + DELIMITER + this.value;
	}
}
