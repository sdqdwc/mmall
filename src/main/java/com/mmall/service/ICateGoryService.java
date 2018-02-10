package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created by WangCH on 2018/2/8.
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildById(Integer categoryId);

}
