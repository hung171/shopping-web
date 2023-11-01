package WebProject.WebProject.service;

import WebProject.WebProject.entity.Outfit;

import java.util.List;


public interface OutfitService {
    List<Outfit> getAllOutfits();
    Outfit createOutfit(Outfit outfit);
    Outfit getOutfitById(int outfitId);
    void deleteOutfit(int outfitId);
}
