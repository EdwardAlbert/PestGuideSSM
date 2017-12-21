package bupt.zby.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bupt.zby.dao.PestDao;
import bupt.zby.entity.PageBean;
import bupt.zby.entity.Pest;
import bupt.zby.entity.PestQuery;
import bupt.zby.service.PestService;

@Service("pestService")
public class PestServiceImpl implements PestService {

	@Autowired
	PestDao pestDao;

	@Override
	public Pest queryPestById(int id) {
		// TODO Auto-generated method stub
		return pestDao.queryPestById(id);
	}

	@Override
	public PageBean queryPageBean(int curPage, int pageSize, PestQuery query) {
		PageBean bean = new PageBean();
		bean.setPageSize(pageSize);
		int count = pestDao.queryCount(query);
		bean.setTotalCount(count);
		if (curPage > bean.getTotalPage())
			curPage = 1;
		bean.setCurrentPage(curPage);
		List<Pest> list = pestDao.queryData((curPage - 1) * pageSize, pageSize, query);
		bean.setData(list);
		bean.setFamilyList(pestDao.queryFamilyList());
		bean.setCategoryList(pestDao.queryCategoryList());
		return bean;
	}

	public List<String> queryFamilyList() {
		return pestDao.queryFamilyList();
	}

	public List<String> queryCategoryList() {
		return pestDao.queryCategoryList();
	}

	public List<Pest> queryData(int curPage, int pageSize, PestQuery query) {
		return pestDao.queryData(curPage, pageSize, query);
	}

	public int queryCount(PestQuery query) {
		return pestDao.queryCount(query);
	}
}
