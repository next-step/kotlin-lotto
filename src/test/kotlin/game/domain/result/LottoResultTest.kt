package game.domain.result

import game.domain.lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoResultTest {
    @ParameterizedTest
    @MethodSource("lottoResultToProfit")
    fun `로또 당첨 결과를 기반으로 수익률을 구할 수 있다`(result: LottoResult, profit: Double) {
        assertThat(result.profit()).isEqualTo(profit)
    }

    companion object {
        @JvmStatic
        private fun lottoResultToProfit(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(LottoResult(listOf(LottoTicketMatchResult(3))), 5.0),
                Arguments.of(LottoResult(listOf(LottoTicketMatchResult(3), LottoTicketMatchResult(2))), 2.5),
                Arguments.of(LottoResult(listOf(LottoTicketMatchResult(3), LottoTicketMatchResult(2), LottoTicketMatchResult(1), LottoTicketMatchResult(0))), 1.25),
                Arguments.of(LottoResult(listOf(LottoTicketMatchResult(3), LottoTicketMatchResult(2), LottoTicketMatchResult(1), LottoTicketMatchResult(0), LottoTicketMatchResult(0))), 1.0),
                Arguments.of(LottoResult(listOf(LottoTicketMatchResult(2))), 0.0),
                Arguments.of(LottoResult(listOf(LottoTicketMatchResult(1))), 0.0),
                Arguments.of(LottoResult(listOf(LottoTicketMatchResult(0))), 0.0)
            )
        }
    }
}