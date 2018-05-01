package service;

import dao.Info;

import java.util.List;

public interface InfoService {

    List<Info> findAll();

    void save(Info info);

    void delete(int infoId);

    Info getById(int infoId);

    void edit(Info info);
}