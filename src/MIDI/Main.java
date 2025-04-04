package midi;
import java.util.*;

//Have to require java.dekstop under module info for this to be accessible.
import javax.sound.midi.*;
import javax.sound.midi.ShortMessage;

import instrumentStrategy.*;


/*
 * MY GUESS:
 * This sounds almost uncanny to Billie Eillish's song "Bad Guy"
 *
 *  Main function is provided from the project specifications.
 *  Parses a provided csv file into a list before adding midi events to a track.
*/
public class Main {
	public static void main(String[] args) {
		
		try {
			//midiEvents is used to generate events for the track that is to be played.
			List<MidiEventData> midiEvents = MidiCsvParser.parse("src/MIDI/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			//Unexpected behavior where the grand piano plays on top of the instrument.
			InstrumentStrategy instrumentStrategy = new ElectricBaseGuitarStrategy();
			instrumentStrategy.applyInstrument(track, 0);
			instrumentStrategy = new TrumpetStrategy();
			instrumentStrategy.applyInstrument(track, 1);
			
			//Trying to get the track to play without messing with other classes at the moment.
			for(MidiEventData event : midiEvents) {
				if(event.getNoteOnOff() == 1) {
					ShortMessage noteOn = new ShortMessage();
					//Assuming the order of arguments based on what javadoc says and mixing it with what the main in 
					noteOn.setMessage(ShortMessage.NOTE_ON, event.getChannel(), event.getNote(), event.getVelocity());
					MidiEvent trackEvent = new MidiEvent(noteOn, event.getStartEndTick());
					track.add(trackEvent);
				}
				else {
					ShortMessage noteOff = new ShortMessage();
					//Assuming that the arguments are note_on, channel, note, and velocity by trial.
					noteOff.setMessage(ShortMessage.NOTE_OFF, event.getChannel(), event.getNote(), event.getVelocity());
					MidiEvent trackEvent = new MidiEvent(noteOff, event.getStartEndTick());
					track.add(trackEvent);
				}
			}		
			//Sequencer starts playing the song. Code is provided directly from the project specifications.
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			while(sequencer.isRunning() | sequencer.isOpen()) {
				Thread.sleep(100);
			}
			Thread.sleep(500);
			sequencer.close();
			System.out.println("Done");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
