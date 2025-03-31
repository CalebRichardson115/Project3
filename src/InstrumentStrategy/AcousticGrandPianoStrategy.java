package InstrumentStrategy;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
//Changes the instrument to be an acoustic grand piano.
public class AcousticGrandPianoStrategy implements InstrumentStrategy{
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage newInstrument = new ShortMessage();
			//Uses 56 for the midi number for an acoustic grand piano
			//Need the last argument to apply at tick 0 correctly.
			newInstrument.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0);
			MidiEvent event = new MidiEvent(newInstrument, 0);
			//Should make the channel into an acoustic grand piano for the duration of the song.
			track.add(event);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
