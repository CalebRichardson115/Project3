package eventFactory;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
//Creates midi events to be added into the track through short messages with legato design.
public class LegatoMidiEventFactory implements MidiEventFactory {
	//Creates longer durations for on notes by adding 80 to the tick.
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage noteOn = new ShortMessage();
		noteOn.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		MidiEvent trackEvent = new MidiEvent(noteOn, (tick+80));
		return trackEvent;
	}
	//Keeps note gaps minimal by not manipulating off note creation.
	@Override
	public MidiEvent createNoteOff(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage noteOff = new ShortMessage();
		noteOff.setMessage(ShortMessage.NOTE_OFF, channel, note, velocity);
		MidiEvent trackEvent = new MidiEvent(noteOff, tick);
		return trackEvent;
	}

}
