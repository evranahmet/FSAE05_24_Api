package pojos.go_rest_users;

public class Links{
	private String next;
	private String current;
	private Object previous;

	public Links() {
	}

	public Links(String next, String current, Object previous) {
		this.next = next;
		this.current = current;
		this.previous = previous;
	}

	public void setNext(String next){
		this.next = next;
	}

	public Object getNext(){
		return next;
	}

	public void setCurrent(String current){
		this.current = current;
	}

	public String getCurrent(){
		return current;
	}

	public void setPrevious(Object previous){
		this.previous = previous;
	}

	public Object getPrevious(){
		return previous;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"next = '" + next + '\'' + 
			",current = '" + current + '\'' + 
			",previous = '" + previous + '\'' + 
			"}";
		}
}
