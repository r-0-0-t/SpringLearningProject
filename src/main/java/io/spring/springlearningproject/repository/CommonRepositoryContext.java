package io.spring.springlearningproject.repository;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author Ishan
 * Date: Jan 17, 2022
 */
@Repository
public class CommonRepositoryContext implements RepositoryContext {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CommonRepositoryContext(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public <T> List<T> getAllItems(Class<T> tClass) {
        return mongoTemplate.findAll(tClass);
    }

    @Override
    public <T> T getItemById(Class<T> tClass, String id) {
        return mongoTemplate.findById(id, tClass);
    }

    @Override
    public <T> T saveOne(T t) {
        return mongoTemplate.save(t);
    }

    @Override
    public <T> long deleteById(Class<T> tClass, Object id) {
        Query query = new Query((Criteria.where("id").is(id)));
        DeleteResult deleteResult = mongoTemplate.remove(query, tClass);
        if(deleteResult.wasAcknowledged()) {
            return deleteResult.getDeletedCount();
        }
        return 0;
    }
}
