package webtend.db.ebean;

import java.util.Iterator;
import java.util.List;

import com.avaje.ebean.PagingList;
import com.avaje.ebean.Query;

public class Pager<T> implements Iterable<T> {

	private int page;

	private int pageSize;

	private int totalCount;

	private int pageCount;

	private List<T> list;

	public Pager(List<T> list, int page, int pageSize, int totalCount) {
		this.list = list;
		this.page = page;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.pageCount = totalCount / pageSize
				+ (totalCount % pageSize == 0 ? 0 : 1);
	}

	public Pager(Query query, int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
		PagingList pageList = query.findPagingList(pageSize);
		// page of pageList starts at 0
		this.list = pageList.getPage(page - 1).getList();
		this.totalCount = pageList.getTotalRowCount();
		this.pageCount = pageList.getTotalPageCount();
	}

	public Iterator<T> iterator() {
		return list.iterator();
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getPage() {
		return page;
	}

	public List<T> getList() {
		return this.list;
	}

}
