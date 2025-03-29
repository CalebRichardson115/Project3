package MIDI;
import java.util.*;
//Have to require java.dekstop under module info for this to be accessible.
import javax.sound.midi.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<MidiEventData> midiEvents = MidiCsvParser.parse("src/MIDI/mystery_song.csv");
		//Testing if parsed correctly.
		System.out.println(midiEvents.get(710).getNoteOnOff());
	}

}
