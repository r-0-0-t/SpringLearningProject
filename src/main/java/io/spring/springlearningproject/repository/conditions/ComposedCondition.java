package io.spring.springlearningproject.repository.conditions;

import org.springframework.data.mongodb.core.query.Criteria;

/**
 * @author Ishan
 * Date: Jan 18, 2022
 */
public class ComposedCondition implements Condition {
    private final Criteria criteria;

    public ComposedCondition() {
        criteria = new Criteria();
    }

    public void addCondition(Condition condition) {
        criteria.andOperator(condition.getAllCriteria());
    }

    @Override
    public Criteria getAllCriteria() {
        return criteria;
    }
}
