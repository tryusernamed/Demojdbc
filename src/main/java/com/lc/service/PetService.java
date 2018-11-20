package com.lc.service;

import com.lc.entity.PetInfo;

import java.util.List;

public interface PetService {

    public int addPet(PetInfo petInfo);

    public int delPet(int id);

    public int modifyPet(PetInfo petInfo);

    public List<PetInfo> findPet();

}
