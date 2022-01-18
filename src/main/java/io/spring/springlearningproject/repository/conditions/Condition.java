package io.spring.springlearningproject.repository.conditions;

import org.springframework.data.mongodb.core.query.Criteria;

/**
 * @author Ishan
 * Date: Jan 18, 2022
 */
public interface Condition {
    Criteria getAllCriteria();
}
