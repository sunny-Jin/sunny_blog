package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.WriteDao;
import ssm.model.Article;
import ssm.service.WriteService;

import javax.annotation.Resource;

@Service
public class WriteServiceImpl implements WriteService {

    @Resource
    private WriteDao writeDao;
    public Article getContent() {
        return writeDao.getContent();
    }

    public int addContent(String content) {
       return writeDao.addContent(content);
    }
}
