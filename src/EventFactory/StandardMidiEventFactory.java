package eventFactory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
//Creates midi events to be added into the track through short messages.
//Since no parameter for whether the note is on or off is given, there needs to be two methods for note creation.
public class StandardMidiEventFactory implements MidiEventFactory {
	@Override
	//Creates on notes by passing the given parameters to the setMessage method and then creates a midi event with the tick parameter to return.
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage noteOn = new ShortMessage();
		noteOn.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent trackEvent = new MidiEvent(noteOn, tick);
		return trackEvent;
	}
	//Creates off notes by passing the given parameters to the setMessage method and then creates a midi event with the tick parameter to return.
	@Override
	public MidiEvent createNoteOff(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage noteOff = new ShortMessage();
		noteOff.setMessage(ShortMessage.NOTE_OFF, channel, note, velocity);
		MidiEvent trackEvent = new MidiEvent(noteOff, tick);
		return trackEvent;
	}

}
