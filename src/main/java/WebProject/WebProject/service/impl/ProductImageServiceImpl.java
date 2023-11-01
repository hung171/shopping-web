package WebProject.WebProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebProject.WebProject.entity.ProductImage;
import WebProject.WebProject.repository.ProductImageRepository;
import WebProject.WebProject.service.ProductImageService;

import javax.transaction.Transactional;

@Service
public class ProductImageServiceImpl implements ProductImageService{
	@Autowired
	ProductImageRepository productImageRepository;

	@Override
	public void save(ProductImage productImage) {
		productImageRepository.save(productImage);
	}

	@Override
	public void deleteById(int id) {
		productImageRepository.deleteById(id);
	}

	@Override
	public void deleteByProductId(int productId) {
		productImageRepository.deleteProductImageByProductId(productId);
	}


}
