package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BankDao;
import service.BankService;

@Service(value = "bankService")
@Transactional
public class BankServiceImpl implements BankService {
	@Resource
	private BankDao bankDao;

	@Override
	public void transferAccounts(final int count, final int userIdA, final int userIdB) {
		// TODO Auto-generated method stub

		bankDao.outMoney(count, userIdA);
		bankDao.inMoney(count, userIdB);
	}

}
