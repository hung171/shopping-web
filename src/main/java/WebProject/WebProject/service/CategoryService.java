package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.entity.Category;

public interface CategoryService {

	Category getCategoryById(int id);

	List<Category> findAll();

}
