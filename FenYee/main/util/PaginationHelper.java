package util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaginationHelper {
  // 数据总数
  private int totalCount;
  public int getTotalCount() {
	return totalCount;
}

public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
}

public int getCountPerPage() {
	return countPerPage;
}

public void setCountPerPage(int countPerPage) {
	this.countPerPage = countPerPage;
}

// 每页数据数
  private int countPerPage;

  public int getPageCount() {
    return totalCount % countPerPage == 0 ? totalCount / countPerPage : totalCount / countPerPage + 1;
  }

  public int getCurrentPageStart(int currentPage) {
    if (currentPage < 1 || currentPage > getPageCount()) {
      throw new RuntimeException("页数错误");
    }
    return (currentPage - 1) * countPerPage;
  }

  public int getCurrentPageEnd(int currentPage) {
    if (currentPage < 1 || currentPage > getPageCount()) {
      throw new RuntimeException("页数错误");
    }
    // 三元运算符
    return getCurrentPageStart(currentPage) + countPerPage > totalCount ?
            totalCount : getCurrentPageStart(currentPage) + countPerPage;
  }
}
