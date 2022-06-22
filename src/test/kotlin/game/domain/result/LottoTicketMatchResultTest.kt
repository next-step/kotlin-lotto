package game.domain.result

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class LottoTicketMatchResultTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 7])
    fun `로또 번호 일치 개수는 6개를 초과할 수 없다`(matchCount: Int) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { LottoTicketMatchResult(matchCount, false) }
    }

    @ParameterizedTest
    @MethodSource("matchResultToRank")
    fun `번호 매치 결과는 당첨 결과가 된다`(result: LottoTicketMatchResult, rank: Rank) {
        assertThat(result.rank).isEqualTo(rank)
    }

    companion object {
        @JvmStatic
        fun matchResultToRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(LottoTicketMatchResult(6, false), Rank.FIRST),
                Arguments.of(LottoTicketMatchResult(5, true), Rank.SECOND),
                Arguments.of(LottoTicketMatchResult(5, false), Rank.THIRD),
                Arguments.of(LottoTicketMatchResult(4, true), Rank.FOURTH),
                Arguments.of(LottoTicketMatchResult(4, false), Rank.FOURTH),
                Arguments.of(LottoTicketMatchResult(3, true), Rank.FIFTH),
                Arguments.of(LottoTicketMatchResult(3, false), Rank.FIFTH),
                Arguments.of(LottoTicketMatchResult(2, true), Rank.NONE),
                Arguments.of(LottoTicketMatchResult(1, true), Rank.NONE),
                Arguments.of(LottoTicketMatchResult(0, true), Rank.NONE)
            )
        }
    }
}
