package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("로또결과(MatchResult)")
class MatchResultTest {

    @Test
    fun `매칭결과를 통해 생성할 수 있다`() {
        val matchResultMap = MatchBoard.values().associateWith { 0 }
        val matchResult: MatchResult = MatchResult.of(matchResultMap)

        assertAll(
            { assertThat(matchResult).isNotNull },
            { assertThat(matchResult).isExactlyInstanceOf(MatchResult::class.java) }
        )
    }
}