package midi;
import java.util.*;

//Have to require java.dekstop under module info for this to be accessible.
import javax.sound.midi.*;

import instrumentStrategy.*;
import pitchStrategy.*;
import eventFactory.*;


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
			
			
			//Choose a factory.
			//MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
			//MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
			MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			//Choose an instrument strategy.
			InstrumentStrategy instrumentStrategy = new ElectricBaseGuitarStrategy();
			instrumentStrategy.applyInstrument(track, 0);
			instrumentStrategy = new TrumpetStrategy();
			instrumentStrategy.applyInstrument(track, 1);
			
			//Choose a pitch strategy
			PitchStrategy pitchStrategy = new HigherPitchStrategy();
			//PitchStrategy pitchStrategy = new LowerPitchStrategy();
			
			//Trying to get the track to play without messing with other classes at the moment.
			for(MidiEventData event : midiEvents) {
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				//Can call more times to get higher/lower pitch
				modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
				
				//Same statement as the provided main.
				if(event.getNoteOnOff() == 1) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				}
				else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
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
