package board.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class ArticleTest {

    @Test
    public void 게시글_객체_정상_생성_테스트() {
        // given & then
        assertDoesNotThrow(() -> new Article(1L, "content", "hashtags",
                LocalDateTime.now(), "creator", LocalDateTime.now(), "updator"));
    }
}
