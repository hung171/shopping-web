package WebProject.WebProject.service.impl;

import WebProject.WebProject.entity.DiscountCode;
import WebProject.WebProject.repository.DiscountCodeRepository;
import WebProject.WebProject.service.DiscountCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeImpl implements DiscountCodeService {

    @Autowired
    DiscountCodeRepository discountCodeRepository;
    @Override
    public void saveDiscountCode(DiscountCode discountCode) {
        discountCodeRepository.save(discountCode);
    }

    @Override
    public DiscountCode findByCode(String code) {
        return discountCodeRepository.findByCode(code);
    }

    @Override
    public DiscountCode findById(int id) {
        return discountCodeRepository.findById(id);
    }

    @Override
    public void deleteCode(int codeId) {
        discountCodeRepository.deleteById(codeId);
    }

    @Override
    public List<DiscountCode> findAll() {
        return discountCodeRepository.findAll();
    }
}
