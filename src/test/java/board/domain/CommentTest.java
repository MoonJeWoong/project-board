package board.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class CommentTest {

    @Test
    public void 댓글_객체_정상_생성_테스트() {
        // given
        Article article = new Article(1L, "content", "hashtags",
                LocalDateTime.now(), "creator", LocalDateTime.now(), "updator");

        // then
        assertDoesNotThrow(() -> new Comment(1L, article, "hashtags",
                LocalDateTime.now(), "creator", LocalDateTime.now(), "updator"));
    }
}
