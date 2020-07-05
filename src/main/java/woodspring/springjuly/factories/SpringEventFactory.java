package woodspring.springjuly.factories;

import com.lmax.disruptor.EventFactory;

import woodspring.springjuly.envents.SpringEvent;

public class SpringEventFactory<T> implements EventFactory<SpringEvent<T>> {

	public SpringEventFactory() {}
		
	@Override
	public SpringEvent<T> newInstance() {
		// TODO Auto-generated method stub
		return new SpringEvent();
	}

}
