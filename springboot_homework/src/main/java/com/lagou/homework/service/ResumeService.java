package com.lagou.homework.service;

import java.util.List;

import com.lagou.homework.pojo.Resume;

public interface ResumeService {
    List<Resume> queryResumeList() throws Exception;

    Resume queryResumeById(Integer id);

    void updateResumeById(Resume resume);

    void deleteResumeById(long longValue);
}
