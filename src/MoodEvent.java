import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class MoodEvent {
	public static final String DELIMITER = ";";

	private List<Mood> moods;
	private DateTime eventTime;
	
	public MoodEvent(DateTime eventTime, List<Mood> moods){
		this.eventTime = eventTime;
		this.moods = moods;
	}
	
	public MoodEvent(DateTime eventTime, Mood... moods){
		this.eventTime = eventTime;
		
		this.moods = new ArrayList<Mood>();
		for(Mood mood : moods){
			this.moods.add(mood);
		}
	}
	
	public List<Mood> getMoods(){
		return this.moods;
	}
	
	public DateTime getEventTime(){
		return this.eventTime;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.eventTime.toString() + " - ");
		for(Mood mood : moods){
			sb.append(mood.toString() + DELIMITER);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString(); 
	}
}
