package woodspring.springjuly.envents;

public class SpringEvent<T> {
	private T obj;
	public SpringEvent() {}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "SpringEvent [obj=" + obj.toString() + "]";
	}
	

}
