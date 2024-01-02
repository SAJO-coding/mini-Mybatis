package com.sajo.mini.service;

import com.sajo.mini.mapper.ItemMapper;
import com.sajo.mini.model.dto.ItemDTO;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.util.List;

import static com.sajo.mini.common.Template.getSqlSession;


public class ProductService {

    private ItemMapper mapper;
    //카테고리 전체 조회용 메소드
    /* 설명. 카테고리 전체 조회용 메소드 */
    public List<ItemDTO> selectAllItem() {
        SqlSession sqlSesstion = getSqlSession();

        mapper = sqlSesstion.getMapper(ItemMapper.class);

        List<ItemDTO> itemDTOList = mapper.selectAllItem();
        sqlSesstion.close();
        return itemDTOList;
    }

    public int productRegistration(ItemDTO itemDTO) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ItemMapper.class);
        int result = mapper.insertItem(itemDTO);
        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }

    public int productDelete(String itemName) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ItemMapper.class);
        int result = mapper.productDelete(itemName);
        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }
}
