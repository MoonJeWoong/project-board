package board.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CommentTest {

    @Test
    public void 댓글_객체_정상_생성_테스트() {
        // given
        Article article = Article.of("title", "content", "hashtags");

        // then
        assertDoesNotThrow(() -> Comment.of(article, "content"));
    }
}
