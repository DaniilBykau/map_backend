package pg.edu.map.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pg.edu.map.model.Point;
import pg.edu.map.repo.PointRepo;
import pg.edu.map.exception.PointNotFoundException;

import java.util.List;

@Service
public class PointService {
    private final PointRepo pointRepo;

    @Autowired
    public PointService(PointRepo pointRepo) {
        this.pointRepo = pointRepo;
    }

    public Point addPoint(Point point) {
        return pointRepo.save(point);
    }

    public List<Point> findAllPoints() {
        return pointRepo.findAll();
    }

    public Point updatePoint(Point point) {
        return pointRepo.save(point);
    }

    public void deletePoint(Long id) {
        pointRepo.deletePointById(id);
    }

    public Point findPointById(Long id) {
        return pointRepo.findPointById(id);
    }

}
