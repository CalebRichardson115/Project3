package instrumentStrategy;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
//Changes the instrument to be an acoustic grand piano at tick 0.
public class AcousticGrandPianoStrategy implements InstrumentStrategy{
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage newInstrument = new ShortMessage();
			//Uses 0 for the midi number for an acoustic grand piano
			newInstrument.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 0, 0);
			MidiEvent event = new MidiEvent(newInstrument, 0);
			//Makes the channel into an acoustic grand piano for the duration of the song.
			track.add(event);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
