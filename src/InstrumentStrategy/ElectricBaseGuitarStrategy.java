package InstrumentStrategy;

import javax.sound.midi.*;
import javax.sound.midi.ShortMessage;
//Applies the electric base guitar to a given channel at tick 0.
public class ElectricBaseGuitarStrategy implements InstrumentStrategy {
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage newInstrument = new ShortMessage();
			//Uses 33 for the Midi electric base guitar number. 
			newInstrument.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
			MidiEvent event = new MidiEvent(newInstrument, 0);
			//Should make the channel into an electric base guitar for the duration of the song.
			track.add(event);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
