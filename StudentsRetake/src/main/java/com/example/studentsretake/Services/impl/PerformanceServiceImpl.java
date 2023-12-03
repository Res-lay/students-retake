package com.example.studentsretake.Services.impl;

import com.example.studentsretake.Entities.Performance;
import com.example.studentsretake.Entities.Student;
import com.example.studentsretake.Repos.PerformanceRepo;
import com.example.studentsretake.Services.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepo performanceRepo;

    @Override
    public Performance create(Performance performance) {
        return performanceRepo.save(performance);
    }

    @Override
    public Performance read(Long id) {
        return performanceRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Performance> readByStudent(Student student) {
        return performanceRepo.findAllByStudent(student);
    }

    @Override
    public Performance update(Long id, Performance newPerformance) {
        Performance performanceFromDb = performanceRepo.findById(id).orElseThrow();
        performanceFromDb.setMark(newPerformance.getMark());
        performanceFromDb.setStudent(newPerformance.getStudent());
        performanceFromDb.setSubject(newPerformance.getSubject());

        return performanceRepo.save(performanceFromDb);
    }

    @Override
    public void delete(Long id) {
        performanceRepo.deleteById(id);
    }
}
