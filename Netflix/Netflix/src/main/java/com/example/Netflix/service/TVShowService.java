
package com.example.Netflix.service;

        import com.example.Netflix.model.TVShow;
        import com.example.Netflix.repository.TVShowRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
public interface TVShowService {
    TVShow saveTVShow(TVShow TVShow);
    List<TVShow> getAllTVShow();
    TVShow getTVShowById(long id);
    TVShow updateTVShow(TVShow TVShow,long id);
    void deleteTVShow(long id);
}