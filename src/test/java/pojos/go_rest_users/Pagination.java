package pojos.go_rest_users;

public class Pagination{
	private Integer total;
	private Integer pages;
	private Integer limit;
	private Links links;
	private Integer page;

	public Pagination() {
	}

	public Pagination(Integer total, Integer pages, Integer limit, Links links, Integer page) {
		this.total = total;
		this.pages = pages;
		this.limit = limit;
		this.links = links;
		this.page = page;
	}

	public void setTotal(Integer total){
		this.total = total;
	}

	public Integer getTotal(){
		return total;
	}

	public void setPages(Integer pages){
		this.pages = pages;
	}

	public Integer getPages(){
		return pages;
	}

	public void setLimit(Integer limit){
		this.limit = limit;
	}

	public Integer getLimit(){
		return limit;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setPage(Integer page){
		this.page = page;
	}

	public Integer getPage(){
		return page;
	}

	@Override
 	public String toString(){
		return 
			"Pagination{" + 
			"total = '" + total + '\'' + 
			",pages = '" + pages + '\'' + 
			",limit = '" + limit + '\'' + 
			",links = '" + links + '\'' + 
			",page = '" + page + '\'' + 
			"}";
		}
}
