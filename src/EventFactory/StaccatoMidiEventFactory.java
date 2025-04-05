package eventFactory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
//Creates midi events to be added into the track through short messages with staccato design.
public class StaccatoMidiEventFactory implements MidiEventFactory {
	//Does nothing to the tick of on notes so that notes are more separated by off notes.
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage noteOn = new ShortMessage();
		noteOn.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent trackEvent = new MidiEvent(noteOn, tick);
		return trackEvent;
	}
	//Adds 120 to the creation of off notes so that notes are more separated.
	@Override
	public MidiEvent createNoteOff(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage noteOff = new ShortMessage();
		noteOff.setMessage(ShortMessage.NOTE_OFF, channel, note, velocity);
		MidiEvent trackEvent = new MidiEvent(noteOff, (tick+120));
		return trackEvent;
	}

}
