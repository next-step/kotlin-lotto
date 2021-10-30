package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

@DisplayName("로또결과(MatchResult)")
class MatchResultTest {

    @Test
    fun `매칭 결과를 기반으로 생성할 수 있다`() {
        val matchResultMap = MatchBoard.values().associateWith { 0 }
        val matchResult: MatchResult = MatchResult.of(matchResultMap)

        assertAll(
            { assertThat(matchResult).isNotNull },
            { assertThat(matchResult).isExactlyInstanceOf(MatchResult::class.java) }
        )
    }

    @Test
    fun `비어있는 매칭 결과를 입력하면 예외를 발생시킨다`() {
        val exception = assertThrows<EmptyMatchResultMapException> { MatchResult.of(mapOf()) }

        assertThat(exception.message).isEqualTo("")
    }
}