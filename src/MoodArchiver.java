import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;

public class MoodArchiver {
	static Scanner cli = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		File moodFile = new File("E:\\My Stuff\\Desktop\\Mood Log.txt");
		BufferedWriter moodFileWriter = new BufferedWriter(new FileWriter(moodFile, true));
		
		MoodEvent newMoodEvent = getMoodEventFromCli();
		
		moodFileWriter.write(newMoodEvent.toString());
		moodFileWriter.newLine();
		moodFileWriter.flush();
		moodFileWriter.close();
		
		System.out.println("Saved!");
		
		System.exit(0);
	}
	
	public static MoodEvent getMoodEventFromCli(){
		DateTime eventTime = new DateTime();
		
		List<Mood> moods = new ArrayList<Mood>();
		
		for(MoodType type : MoodType.values()){
			boolean fail = false;
			do{
				try {
					Mood nextMood = readMoodFromInput(type);
					moods.add(nextMood);
				} catch (Exception e) {
					fail = true;
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}while(fail == true);
		}
		
		return new MoodEvent(eventTime, moods);
	}
	
	public static Mood readMoodFromInput(MoodType type) throws Exception{
		System.out.println("Are you feeling " + type.toString() + "?");
		
		int i = 0;
		for(String moodValue : type.getMoodValues()){
			System.out.println(i++ + " - " + moodValue);
		}
		
		int input = cli.nextInt();
		
		if(input < 0 || input > type.getMoodValues().size()){
			throw new Exception("Invalid mood value of " + input + " entered for mood type" + type.toString());
		}
		
		return new Mood(type, input);
	}
}
