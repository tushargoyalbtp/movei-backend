package com.practice.springboot.backend_project.Service.Implementation;

import com.practice.springboot.backend_project.Model.Show;
import com.practice.springboot.backend_project.Repository.ShowRepository;
import com.practice.springboot.backend_project.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowServiceImplementation implements ShowService {

    @Autowired private ShowRepository showRepository;
    /**
     * @param show
     * @return
     */
    @Override
    public Show createShow(Show show) {
        return showRepository.save(show);
    }
}
