package bupt.zby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import bupt.zby.entity.Pest;
import bupt.zby.entity.PestQuery;

public interface PestDao {

	public Pest queryPestById(int id);

	public List<Pest> queryData(@Param("startNo") int startNo, @Param("pageSize") int pageSize,
			@Param("pestQuery") PestQuery query);

	public int queryCount(@Param("query")PestQuery query);

	public List<String> queryFamilyList();

	public List<String> queryCategoryList();
}
