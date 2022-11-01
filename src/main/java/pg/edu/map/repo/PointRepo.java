package pg.edu.map.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pg.edu.map.model.Point;

import java.util.Optional;

public interface PointRepo extends JpaRepository<Point, Long> {

    void deletePointById(Long id);

    Point findPointById(Long id);
}
