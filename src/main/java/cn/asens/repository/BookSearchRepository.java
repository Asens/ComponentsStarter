package cn.asens.repository;

import cn.asens.entity.elastic.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface  BookSearchRepository extends ElasticsearchRepository<Book, Long> {

}
