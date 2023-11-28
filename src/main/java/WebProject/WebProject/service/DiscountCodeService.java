package WebProject.WebProject.service;

import WebProject.WebProject.entity.DiscountCode;

import java.util.List;

public interface DiscountCodeService {
    void saveDiscountCode(DiscountCode discountCode);

    DiscountCode findByCode(String code);

    DiscountCode findById(int id);

    void deleteCode(int codeId);

    List<DiscountCode> findAll();
}
