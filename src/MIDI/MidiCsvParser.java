package MIDI;
import java.util.*;
public class MidiCsvParser {
	//A list of events to return. May need to change the development of the class to meet project specification.
	private List<MidiEventData> events;
	//May need to remove if this does not work in main when calling in main.
	public MidiCsvParser() {
		this.events = new ArrayList<MidiEventData>();
	}
	//If needing to change then this should become a static method.
	public List<MidiEventData> parse(String csvFilePath) {
		
		return this.events;
	}
}
