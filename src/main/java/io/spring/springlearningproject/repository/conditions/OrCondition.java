package io.spring.springlearningproject.repository.conditions;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;

/**
 * @author Ishan
 * Date: Jan 18, 2022
 */
@RequiredArgsConstructor
public class OrCondition implements Condition {
    private final Condition leftCondition;
    private final Condition rightCondition;

    @Override
    public Criteria getAllCriteria() {
        Criteria criteria = leftCondition.getAllCriteria();
        criteria.andOperator(rightCondition.getAllCriteria());
        return criteria;
    }
}
