package bupt.zby.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bupt.zby.dao.PestDao;
import bupt.zby.entity.Pest;
import bupt.zby.service.PestService;

@Service("pestService")
public class PestServiceImpl implements PestService {

	@Autowired
	PestDao pestDao;

	@Override
	public Pest selectPestById(int id) {
		// TODO Auto-generated method stub
		return pestDao.selectPestById(id);
	}
}
