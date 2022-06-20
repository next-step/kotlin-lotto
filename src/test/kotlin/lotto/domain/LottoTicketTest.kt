package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTicketTest {
    @ParameterizedTest
    @MethodSource("lottoMatches")
    fun `LottoTicket은 당첨번호와 일치하는 번호 개수를 구할 수 있다`(lottoNumbers: List<Int>, winningNumbers: List<Int>, matchResult: Int) {
        // given
        val lottoTicket = LottoTicket(lottoNumbers)
        val winningNumber = WinningNumber(winningNumbers)
        // when
        // then
        assertThat(lottoTicket.count(winningNumber)).isEqualTo(matchResult)
    }

    companion object {
        @JvmStatic
        fun lottoMatches() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(listOf(1, 2, 3, 4, 5, 36), listOf(1, 2, 3, 4, 5, 6), 5),
            Arguments.of(listOf(1, 2, 3, 4, 35, 36), listOf(1, 2, 3, 4, 5, 6), 4),
            Arguments.of(listOf(1, 2, 3, 34, 35, 36), listOf(1, 2, 3, 4, 5, 6), 3),
            Arguments.of(listOf(1, 2, 33, 34, 35, 36), listOf(1, 2, 3, 4, 5, 6), 2),
            Arguments.of(listOf(1, 32, 33, 34, 35, 36), listOf(1, 2, 3, 4, 5, 6), 1),
            Arguments.of(listOf(31, 32, 33, 34, 35, 36), listOf(1, 2, 3, 4, 5, 6), 0),
        )
    }
}
