package eventFactory;
//Creates a StandardMidiEventFactory to return to the abstract factory.
public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}
}
