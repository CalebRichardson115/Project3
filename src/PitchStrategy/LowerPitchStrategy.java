package pitchStrategy;
//Subtracts a given note by 2 to lower the pitch.
public class LowerPitchStrategy implements PitchStrategy {
	@Override
	public int modifyPitch(int note) {
		note-=2;
		//In case the value passed for the note is 1, then still returns a lower pitch.
		if(note<=0) {
			return 0;
		}
		return note;
	}
}
