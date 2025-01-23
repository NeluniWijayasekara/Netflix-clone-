
package com.example.Netflix.service.impl;
        import com.example.Netflix.model.TVShow;
        import com.example.Netflix.repository.TVShowRepository;
        import com.example.Netflix.service.TVShowService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import java.util.List;
        import java.util.Optional;
@Service
public class TVShowServiceImpl implements TVShowService {
    @Autowired
    private com.example.Netflix.repository.TVShowRepository TVShowRepository;
    //save User in database
    @Override
    public TVShow saveTVShow(TVShow TVShow){
        return TVShowRepository.save(TVShow);
    }
    //get all TVShow form database
    @Override
    public List<TVShow> getAllTVShow() {
        return TVShowRepository.findAll();
    }
    //get TVShow using id
    @Override
    public TVShow getTVShowById(long id) {
        Optional<TVShow> TVShow = TVShowRepository.findById(id);
        if(TVShow.isPresent()){
            return TVShow.get();
        }else {
            throw new RuntimeException();
        }
    }
    //update TVShow
    @Override
    public TVShow updateTVShow(TVShow TVShow, long id) {
        TVShow existingTVShow =
                TVShowRepository.findById(id).orElseThrow(
                        ()-> new RuntimeException()
                );
        existingTVShow.setTitle(TVShow.getTitle());
        existingTVShow.setDescription(TVShow.getDescription());
        existingTVShow.setRating(TVShow.getRating());
// save
        TVShowRepository.save(existingTVShow);
        return existingTVShow;
    }
    @Override
    public void deleteTVShow(long id) {
//check
        TVShowRepository.findById(id).orElseThrow(()-> new
                RuntimeException());
//delete
        TVShowRepository.deleteById(id);
    }
}