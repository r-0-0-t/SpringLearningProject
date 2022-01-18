package io.spring.springlearningproject.repository.conditions;

import io.spring.springlearningproject.enums.Operator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.regex.Pattern;

/**
 * @author Ishan
 * Date: Jan 18, 2022
 */
@RequiredArgsConstructor
public class DefaultCondition implements Condition {

    private final String key;
    private final Operator operator;
    private final Object value;

    @Override
    public Criteria getAllCriteria() {
        Criteria criteria = null;
        switch (operator) {
            case Equal:
                criteria = Criteria.where(key).is(value);
                break;
            case NotEqual:
                criteria = Criteria.where(key).ne(value);
                break;
            case Contains:
                criteria = Criteria.where(key).regex(Pattern.compile(value.toString()));
                break;
            case Any:
                criteria = Criteria.where(key).in(value);
                break;
            default:
                break;
        }
        return criteria;
    }

}
