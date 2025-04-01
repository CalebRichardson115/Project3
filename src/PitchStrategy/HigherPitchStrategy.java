package PitchStrategy;
//Adds 2 to the note to raise the pitch.
public class HigherPitchStrategy implements PitchStrategy {
	public int modifyPitch(int note) {
		note+=2;
		//If the note is at 126, then it will still return a higher pitch.
		if(note >= 127) {
			return 127;
		}
		return note;
	}
}
