package pitchStrategy;
/*
 * Implemented strategies will alter the pitch of the song by adding or subtracting from
 * a given note. However, investigating the note range online reveals it to be 0-127.
 * Therefore, modifyPitch should make it so that the returned note does not exceed or precede that range.
 */
public interface PitchStrategy {
	int modifyPitch(int note);
}
