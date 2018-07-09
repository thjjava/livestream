package com.sttri.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sttri.bean.QueryResult;
import com.sttri.dao.CommonDao;
import com.sttri.pojo.LiveGood;
import com.sttri.service.ILiveGoodService;

@Service
public class LiveGoodServiceImpl implements ILiveGoodService {
	@Autowired
	private CommonDao dao;
	
	@Override
	public void deletebyid(Object id) {
		dao.delete(LiveGood.class, id);
	}

	@Override
	public void deletebyids(Object[] array) {
		dao.delete(LiveGood.class, array);
	}

	@Override
	public LiveGood getById(Object id) {
		return dao.find(LiveGood.class, id);
	}

	@Override
	public List<LiveGood> getResultList(String wherejpql,
			LinkedHashMap<String, String> orderby, Object... queryParams) {
		return dao.getResultList(LiveGood.class, wherejpql, orderby, queryParams);
	}

	@Override
	public QueryResult<LiveGood> getScrollData(int firstindex, int maxresult,
			String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		return dao.getScrollData(LiveGood.class, firstindex, maxresult, wherejpql, queryParams, orderby);
	}

	@Override
	public void save(LiveGood liveGood) {
		dao.save(liveGood);
	}

	@Override
	public void update(LiveGood liveGood) {
		dao.update(liveGood);
	}

}
