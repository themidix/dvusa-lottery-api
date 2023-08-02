package com.midix.dvLottery.services;


import com.midix.dvLottery.entity.Child;

import java.util.List;

public interface ChildService {
	Child saveChild(Child c);
	Child updateChild(Child c);
	void deleteChild(Child c);
	void deleteChildById(Long id);
	Child getChild(Long id);
	List<Child> getAllChildren();
}
