package WebProject.WebProject.service.impl;

import WebProject.WebProject.entity.Outfit;
import WebProject.WebProject.repository.OutfitRepository;
import WebProject.WebProject.repository.Outfit_ProductRepository;
import WebProject.WebProject.repository.ProductRepository;
import WebProject.WebProject.service.OutfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutfitServiceImpl implements OutfitService {
    @Autowired
    private OutfitRepository outfitRepository;

    @Autowired
    private Outfit_ProductRepository outfitProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Outfit> getAllOutfits() {
        return outfitRepository.findAll();
    }

    @Override
    public Outfit createOutfit(Outfit outfit) {
        return outfitRepository.save(outfit);
    }

    @Override
    public Outfit getOutfitById(int outfitId) {
        return outfitRepository.findById(outfitId).orElse(null);
    }

    @Override
    public void deleteOutfit(int outfitId) {
        outfitRepository.deleteById(outfitId);
    }

}

