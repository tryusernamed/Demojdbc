package com.lc.service.impl;

import com.lc.dao.BaseDao;
import com.lc.entity.PetInfo;
import com.lc.service.PetService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetServiceImpl extends BaseDao implements PetService {
    public int addPet(PetInfo petInfo) {
        String sql = "insert into pet values(?,?,?,?,?,?);";
        Object[] param = {null, petInfo.getPetName(), petInfo.getPetBreed(), petInfo.getPetSex(), petInfo.getBirthday(), petInfo.getDescription()};
        return executeUpdate(sql, param);
    }

    public int delPet(int id) {
        String sql = "delete from pet where petid = ?";
        Object[] param = {id};
        return executeUpdate(sql, param);
    }

    public int modifyPet(PetInfo petInfo) {
        String sql = "update pet set petname = ?, petbreed = ?, petsex = ?, birthday = ?, description = ? where petid = ?";
        Object[] param = {petInfo.getPetName(), petInfo.getPetBreed(), petInfo.getPetSex(), petInfo.getBirthday(), petInfo.getDescription(), petInfo.getPetId()};
        return executeUpdate(sql, param);
    }

    public List<PetInfo> findPet() {
        List<PetInfo> pet = new ArrayList<PetInfo>();
        ResultSet rs = executeQuery("select a.petid, a.petname,b.breed,c.sex,a.birthday,a.description from pet a inner join petbreed b on b.breedid = a.petbreed inner join petsex c on c.sexid = a.petsex; ", null);
        try{
            while (rs.next()){
                PetInfo petInfo = new PetInfo();
                petInfo.setPetId(rs.getInt(1));
                petInfo.setPetName(rs.getString(2));
                petInfo.setBreed(rs.getString(3));
                petInfo.setSex(rs.getString(4));
                petInfo.setBirthday(rs.getString(5));
                petInfo.setDescription(rs.getString(6));
                pet.add(petInfo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pet;
    }

}
