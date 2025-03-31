package InstrumentStrategy;

import javax.sound.midi.*;
/*Changes the instrument for a channel to Electric Base Guitar at tick 0.
If it was allowed from the project specifications, having a parameter for the startEndTick
would allow for the implementation to apply the instrument at any tick.
Nonetheless, any class applying this strategy uses the PROGRAM_CHANGE ShortMessage which is used for changing instruments.
*/
public interface InstrumentStrategy {
	void applyInstrument(Track track, int channel);
}
