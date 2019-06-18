package com.tw.model;

import java.util.Map;

/**
 * @author: woodpecker
 * @Date: 2019/6/16 21:45
 */
public class Student {
    private String name;
    private String number;
    private Double mathGrade;
    private Double chineseGrade;
    private Double englishGrade;
    private Double programGrade;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(Double mathGrade) {
        this.mathGrade = mathGrade;
    }

    public Double getChineseGrade() {
        return chineseGrade;
    }

    public void setChineseGrade(Double chineseGrade) {
        this.chineseGrade = chineseGrade;
    }

    public Double getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(Double englishGrade) {
        this.englishGrade = englishGrade;
    }

    public Double getProgramGrade() {
        return programGrade;
    }

    public void setProgramGrade(Double programGrade) {
        this.programGrade = programGrade;
    }
}
