package cn.asens.act;

import cn.asens.entity.elastic.Book;
import cn.asens.repository.BookSearchRepository;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Asens
 */
@RestController
public class SearchAct {
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    private BookSearchRepository bookSearchRepository;

    @GetMapping
    public Object index(){
        Book book = new Book();
        book.setId("1");
        book.setName("first");
        book.setContent("asdasd");
        bookSearchRepository.save(book);
        return book;
    }

    @GetMapping("/search")
    public Object search(String name){
        //bookSearchRepository.
        return bookSearchRepository.findAll();
    }
}
