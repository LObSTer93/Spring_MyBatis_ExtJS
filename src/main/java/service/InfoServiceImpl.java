package service;

import exceptions.InfoNotFoundException;
import dao.Info;
import dao.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Info> findAll() {
        return infoMapper.findAll();
    }

    @Override
    public void save(Info info) {
        infoMapper.save(info);
    }

    @Override
    public void delete(int infoId) {
        infoMapper.delete(infoId);
    }

    @Override
    public Info getById(int infoId) {
        Info info = infoMapper.getById(infoId);
        if(info == null){
            throw new InfoNotFoundException(infoId);
        }
        return info;
    }

    @Override
    public void edit(Info info) {
        infoMapper.edit(info);
    }
}
