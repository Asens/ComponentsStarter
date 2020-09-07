package cn.asens.act;

import cn.asens.entity.elastic.Book;
import cn.asens.repository.BookSearchRepository;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Asens
 */
@RestController
public class SearchAct {
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Resource
    private BookSearchRepository bookSearchRepository;

    @GetMapping("/")
    public Object index(){
        Book book = new Book();
        book.setId("1");
        book.setName("导弹");
        book.setKeyName("导弹");
        book.setType("1");
        book.setContent("依靠自身动力推进，由制导系统控制飞行并导向目标的武器。" +
                "与导弹地面设备、作战勤务保障设备、指挥控制设备等共同构成导弹武" +
                "器系统。陆、海、空军部队等作战的主要武器。它的出现对军事战略、" +
                "作战样式和军队的编制、体制，乃至作战进程都产生过重大影响。导弹" +
                "是在火箭等技术基础上逐步发展而成的。不迟于12世纪中叶，中国出现" +
                "了最早的军用火箭。1926年，美国第一次发射了一枚无控液体火箭。20" +
                "世纪30年代末，德国开始火箭、导弹技术的研究，在第二次世界大战期" +
                "间，率先研制成功 V-1导弹和 V-2导弹，1944年6～9月首次用于袭击英" +
                "国首都伦敦和盟军占领的欧洲城市。这是世界上最早的 巡航导弹和地地" +
                "弹道导弹。战争后期，德国又研制出“龙胆草”地空导弹、X-7反坦克导弹" +
                "、X-4有线制导空空导弹。");
        bookSearchRepository.save(book);

        book.setId("2");
        book.setType("2");
        book.setName("远程导弹");
        book.setKeyName("远程导弹");
        book.setContent("通常指射程在5 000～8 000千米的导弹。各国划分标准不尽一致。" +
                "有的国家把射程3 000～8 000千米的导弹界定为远程导弹。美国和苏联在限" +
                "制战略武器会谈中将射程2 700～5 500千米的弹道导弹规定为中远程导弹。" +
                "见 战略导弹。");
        bookSearchRepository.save(book);

        book.setId("3");
        book.setType("2");
        book.setName("程远");
        book.setKeyName("程远");
        book.setContent("通常指射程在5 000～8 000千米的导弹。各国划分标准不尽一致。" +
                "有的国家把射程3 000～8 000千米的导弹界定为远程导弹。美国和苏联在限" +
                "制战略武器会谈中将射程2 700～5 500千米的弹道导弹规定为中远程导弹。" +
                "见 战略导弹。");
        bookSearchRepository.save(book);
        return book;
    }

    @GetMapping("/search")
    public Object search(String name){
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                //.withQuery(QueryBuilders.matchPhraseQuery())
                .withQuery(QueryBuilders.boolQuery()
                .should(QueryBuilders.queryStringQuery("name:(\""+name+"\")"))
                //.should(QueryBuilders.queryStringQuery("content:(\""+name+"\")"))
                )
                .withHighlightFields(new HighlightBuilder.Field("name"),new HighlightBuilder.Field("content"))
                .build();
        SearchHits<Book> hits = elasticsearchRestTemplate.search(searchQuery,Book.class);
        return hits;
    }
}
