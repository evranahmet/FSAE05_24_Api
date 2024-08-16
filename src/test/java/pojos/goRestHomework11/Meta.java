package pojos.goRestHomework11;

public class Meta{
	private Pagination pagination;

	public Meta() {
	}

	public Meta(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Pagination getPagination(){
		return pagination;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"pagination = '" + pagination + '\'' + 
			"}";
		}
}
