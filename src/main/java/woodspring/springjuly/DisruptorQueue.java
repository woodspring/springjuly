package woodspring.springjuly;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import woodspring.springjuly.envents.SpringEvent;

public class DisruptorQueue<T> {
	private Disruptor<SpringEvent<T>> disruptor;
	private RingBuffer<SpringEvent<T>> ringBuffer;

	public DisruptorQueue(Disruptor<SpringEvent<T>> disruptor) {
		this.disruptor = disruptor;
		this.ringBuffer = disruptor.getRingBuffer();
		this.disruptor.start();		
	}
	
	public void add(T t) {
		if (t != null) {
			long sequence = this.ringBuffer.next();
			try {
			SpringEvent<T> event = (SpringEvent)this.ringBuffer.claimAndGetPreallocated(sequence);
			event.setObj( t);
			} catch(Exception ex) {
				ex.printStackTrace();				
			} finally {
				this.ringBuffer.publish( sequence);
			}
		}
	}
	
	
}
