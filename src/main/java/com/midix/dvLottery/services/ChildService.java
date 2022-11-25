package com.midix.dvLottery.services;

import java.util.List;

import com.midix.dvLottery.models.Child;

public interface ChildService {
	Child saveChild(Child c);
	Child updateChild(Child c);
	void deleteChild(Child c);
	void deleteChildById(Long id);
	Child getChild(Long id);
	List<Child> getAllChildren();
}
