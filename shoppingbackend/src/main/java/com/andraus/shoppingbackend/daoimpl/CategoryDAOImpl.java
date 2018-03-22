package com.andraus.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.andraus.shoppingbackend.dao.CategoryDAO;
import com.andraus.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category(1, "Television", "Televisions Descriptions", "CAT_01.png", true);
		categories.add(category);
		Category category2 = new Category(2, "Moviles", "Moviles Descriptions", "CAT_02.png", true);
		categories.add(category2);
		Category category3 = new Category(3, "Laptop", "Laptop Descriptions", "CAT_03.png", true);
		categories.add(category3);
		
	}
	@Override
	public List<Category> list() {
		
		return categories;
	}
	@Override
	public Category get(int id) {
		
		for(Category category: categories) {
			
			if (category.getId() == id) {
				return category;
			}
		}
		
		return null;
	}

}
