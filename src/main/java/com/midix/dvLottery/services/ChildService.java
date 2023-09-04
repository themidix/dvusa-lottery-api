package com.midix.dvLottery.services;


import com.midix.dvLottery.dto.ChildDTO;
import com.midix.dvLottery.entity.Child;

import java.util.List;

public interface ChildService {
	Child saveChild(Child c);
	ChildDTO updateChild(ChildDTO childDTO);
	void deleteChildById(Long id);
	Child getChild(Long id);
	List<Child> getAllChildren();
}
