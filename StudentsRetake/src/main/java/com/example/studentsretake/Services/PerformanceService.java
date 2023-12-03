package com.example.studentsretake.Services;

import com.example.studentsretake.Entities.Performance;
import com.example.studentsretake.Entities.Student;
import org.hibernate.id.PersistentIdentifierGenerator;

import java.util.List;

public interface PerformanceService {
    Performance create(Performance performance);
    Performance read(Long id);
    List<Performance> readByStudent(Student student);
    Performance update(Long id, Performance newPerformance);
    void delete(Long id);
}
