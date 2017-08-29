package ssm.service;

import ssm.model.Article;

public interface WriteService {

    Article getContent();
    int addContent(String content);
}
