package eventFactory;
//Creates a LegatoMidiEventFactory to return to the abstract factory.
public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}
}
