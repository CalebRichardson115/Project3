package eventFactory;

import javax.sound.midi.*;
public interface MidiEventFactory {
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	MidiEvent createNoteOff(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
}
