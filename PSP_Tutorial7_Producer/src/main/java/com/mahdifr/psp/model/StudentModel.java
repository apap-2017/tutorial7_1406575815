package com.mahdifr.psp.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel
{
    private String npm;
    @Size(min=1)
    @NotNull
    private String name;
    @NotNull
    private double gpa;
    private List<CourseModel> courses;
}