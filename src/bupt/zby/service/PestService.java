package bupt.zby.service;

import bupt.zby.entity.PageBean;
import bupt.zby.entity.Pest;
import bupt.zby.entity.PestQuery;

public interface PestService {
	public Pest queryPestById(int id);

	public PageBean queryPageBean(PestQuery query);
}
