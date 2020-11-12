package com.d.ddmall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.d.common.utils.PageUtils;
import com.d.common.utils.Query;

import com.d.ddmall.product.dao.CategoryDao;
import com.d.ddmall.product.entity.CategoryEntity;
import com.d.ddmall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //组装成父子的树形结构
        //找一级分类,父分类id为0
        List<CategoryEntity> level1Menu = entities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map((menu) -> {menu.setChildren(getChildrens(menu,entities)); return menu;})
                .sorted((menu1,menu2)->{ return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());})
                .collect(Collectors.toList());

        return level1Menu;
    }

//root 当前菜单 all子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        })
                //找到子菜单
                .map(categoryEntity -> {categoryEntity.setChildren(getChildrens(categoryEntity,all));
                return categoryEntity;})
                //排序
                .sorted((menu1,menu2)->{ return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());})
                .collect(Collectors.toList());
        return null;
    }
}