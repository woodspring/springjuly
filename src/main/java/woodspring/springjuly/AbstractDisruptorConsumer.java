package woodspring.springjuly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

import woodspring.springjuly.envents.SpringEvent;

public abstract class AbstractDisruptorConsumer<T> implements EventHandler<SpringEvent<T>>, WorkHandler<SpringEvent<T>> {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	public  AbstractDisruptorConsumer() {}
	
	@Override
	public void onEvent(SpringEvent<T> event) throws Exception {
		logger.info("onEvent:[%s]", event.toString());
		this.consume(event.getObj());
	}

	@Override
	public void onEvent(SpringEvent<T> event, long sequence, boolean endOfBatch) throws Exception {
		logger.info("onEvent:[%s], sequence:%ld,", event.toString(), sequence);
		this.onEvent( event);		
	}
	
	public abstract void consume(T var1);

}
