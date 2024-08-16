package pojos.go_rest_users;

import java.util.List;

public class GorestPojo{
	private List<DataItem> data;
	private Meta meta;

//	public GorestPojo() {
//	}
//
//	public GorestPojo(List<DataItem> data, Meta meta) {
//		this.data = data;
//		this.meta = meta;
//	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	@Override
 	public String toString(){
		return 
			"GorestPojo{" + 
			"data = '" + data + '\'' + 
			",meta = '" + meta + '\'' + 
			"}";
		}
}