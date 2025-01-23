
package com.example.Netflix.service.impl;
        import com.example.Netflix.model.Recommendation;
        import com.example.Netflix.repository.RecommendationRepository;
        import com.example.Netflix.service.RecommendationService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import java.util.List;
        import java.util.Optional;
@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private com.example.Netflix.repository.RecommendationRepository RecommendationRepository;
    //save Recommendation in database
    @Override
    public Recommendation saveRecommendation(Recommendation Recommendation){
        return RecommendationRepository.save(Recommendation);
    }
    //get all Recommendation form database
    @Override
    public List<Recommendation> getAllRecommendation() {
        return RecommendationRepository.findAll();
    }
    //get Recommendation using id
    @Override
    public Recommendation getRecommendationById(long id) {
        Optional<Recommendation> Recommendation = RecommendationRepository.findById(id);
        if(Recommendation.isPresent()){
            return Recommendation.get();
        }else {
            throw new RuntimeException();
        }
    }
    //update Recommendation
    @Override
    public Recommendation updateRecommendation(Recommendation Recommendation, long id) {
        Recommendation existingRecommendation =
                RecommendationRepository.findById(id).orElseThrow(()-> new RuntimeException()
                );
        existingRecommendation.setEmail(Recommendation.getEmail());
        existingRecommendation.setMovie_or_tvShow(Recommendation.getMovie_or_tvShow());

        existingRecommendation.setScore(Recommendation.getScore());
// save
        RecommendationRepository.save(existingRecommendation);
        return existingRecommendation;
    }
    @Override
    public void deleteRecommendation(long id) {
//check
        RecommendationRepository.findById(id).orElseThrow(()-> new RuntimeException());
//delete
        RecommendationRepository.deleteById(id);
    }
}