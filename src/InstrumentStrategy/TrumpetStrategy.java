package InstrumentStrategy;

import javax.sound.midi.*;
import javax.sound.midi.ShortMessage;
//Applies the electric base guitar to a given channel at tick 0.
public class TrumpetStrategy implements InstrumentStrategy {
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage newInstrument = new ShortMessage();
			//Uses 56 for the midi number for a trumpet.
			//Need the last argument to apply at tick 0 correctly.
			newInstrument.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
			MidiEvent event = new MidiEvent(newInstrument, 0);
			//Should make the channel into a trumpet for the duration of the song.
			track.add(event);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
