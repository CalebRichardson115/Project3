package eventFactory;
//Creates a StaccatoMidiEventFactory to return to the abstract factory.
public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}
}
