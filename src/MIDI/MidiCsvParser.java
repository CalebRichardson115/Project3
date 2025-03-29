package MIDI;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MidiCsvParser {
	//Needs to be static due to project specifications for Main.
	public static List<MidiEventData> parse(String csvFilePath) {
		//List of returned events from csv file.
		List<MidiEventData> events = new ArrayList<>();
		//Catches any exceptions in reading the csv file and lines.
		try {
			Scanner filePath = new Scanner(new FileInputStream(csvFilePath));
			while(filePath.hasNextLine()) {
				/*Puts all of the line data into a String that is then converted to a list of each data point. 
				 * Each data point that is separated by a comma is its own element in the list.
				 * */
				String lineData = filePath.nextLine();
				String[] midiElements = lineData.split(",");
				//Gets each value of midiElements to compose an instance of midiEventData.
				int startEndTick = Integer.valueOf(midiElements[0]);
				int noteOnOff;
				//Need to fix the conditionals but otherwise should be fine.
				if(midiElements[1] == "Note_on_c") {
					noteOnOff = 1;
				}
				else if(midiElements[1] == "Note_off_c") {
					noteOnOff = 0;
				}
				else {
					noteOnOff = -1;
				}
				int channel = Integer.valueOf(midiElements[2]);
				int note = Integer.valueOf(midiElements[3]);
				int velocity = Integer.valueOf(midiElements[4]);
				int instrument = Integer.valueOf(midiElements[5]);
				//Creates a new Midi event to be added into the list.
				MidiEventData event = new MidiEventData(channel, note, startEndTick, velocity, instrument, noteOnOff);
				events.add(event);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Error in reading file.");
		}
		return events;
	}
}
