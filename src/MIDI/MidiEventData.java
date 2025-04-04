package midi;

public class MidiEventData {
	//Provided code from the project specifications.
	private int channel;
	private int note;
	private int startEndTick;
	private int endTick;
	private int velocity;
	private int noteOnOff;
	private int instrument;
	
	public MidiEventData(int channel, int note, int startEndTick, int velocity, int instrument, int noteOnOff) {
		this.channel = channel;
		this.note = note;
		this.startEndTick = startEndTick;
		this.velocity = velocity;
		this.instrument = instrument;
		this.noteOnOff = noteOnOff;
	}
	//Getters and setters for MidiEventData
	public int getChannel() {
		return this.channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getNote() {
		return this.note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public int getStartEndTick() {
		return this.startEndTick;
	}
	public void setStartTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}
	public int getVelocity() {
		return this.velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	public int getInstrument() {
		return this.instrument;
	}
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}
	public int getNoteOnOff() {
		return this.noteOnOff;
	}
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

}
