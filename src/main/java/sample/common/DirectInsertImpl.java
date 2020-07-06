package sample.common;

import lombok.AllArgsConstructor;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

@AllArgsConstructor
public class DirectInsertImpl<T, ID> implements DirectInsert<T> {

    private final JdbcAggregateTemplate template;

    @Override
    public T insert(T entity) {
        return template.insert(entity);
    }
}
