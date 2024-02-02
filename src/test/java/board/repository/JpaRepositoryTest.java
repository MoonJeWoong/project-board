package board.repository;

import static org.assertj.core.api.Assertions.*;

import board.config.JpaConfig;
import board.domain.Article;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SuppressWarnings("NonAsciiCharacters")
@ActiveProfiles("testdb")
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    void 기본_조회_테스트() {
        // when
        List<Article> articles = articleRepository.findAll();

        // then
        assertThat(articles)
                .isNotNull()
                .hasSize(123);
    }

    @Test
    void 기본_생성_테스트() {
        // given
        long previousCount = articleRepository.count();
        Article newArticle = Article.of("new article", "new content", "#spring");

        // when
        newArticle = articleRepository.save(newArticle);
        long currentCount = articleRepository.count();

        // then
        assertThat(currentCount).isEqualTo(previousCount + 1);
    }

    @Test
    void 기본_수정_테스트() {
        // given
        Article existedArticle = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#SpringBoot";
        existedArticle.setHashtag(updatedHashtag);

        // when
        existedArticle = articleRepository.save(existedArticle);

        // then
        assertThat(existedArticle.getHashtag()).isEqualTo(updatedHashtag);
    }

    @Test
    void 기본_삭제_테스트() {
        // given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousCommentSize = commentRepository.count();
        int deletedCommentSize = article.getComments().size();

        // when
        articleRepository.delete(article);
        long afterArticleCount = articleRepository.count();
        long afterCommentCount = commentRepository.count();

        // then
        assertThat(afterArticleCount).isEqualTo(previousArticleCount - 1);
        assertThat(afterCommentCount).isEqualTo(previousCommentSize - deletedCommentSize);
    }
}
