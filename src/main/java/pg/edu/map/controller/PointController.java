package pg.edu.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pg.edu.map.model.Point;
import pg.edu.map.service.PointService;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/map")
public class PointController {
    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Point>> getAllPoints() {
        List<Point> points = pointService.findAllPoints();
        return new ResponseEntity<>(points, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Point> getPointById(@PathVariable("id") Long id) {
        Point point = pointService.findPointById(id);
        return new ResponseEntity<>(point, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Point> addPoint(@RequestBody Point point) {
        Point newPoint = pointService.addPoint(point);
        return new ResponseEntity<>(newPoint, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Point> updatePoint(@RequestBody Point point) {
        Point updatePoint = pointService.updatePoint(point);
        return new ResponseEntity<>(updatePoint, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePoint(@PathVariable("id") Long id) {
        pointService.deletePoint(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
