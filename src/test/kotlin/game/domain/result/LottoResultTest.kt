package game.domain.result

import org.assertj.core.api.Assertions.assertThat
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
                Arguments.of(createLottoResult(listOf(3)), 5.0),
                Arguments.of(createLottoResult(listOf(3, 2)), 2.5),
                Arguments.of(createLottoResult(listOf(3, 2, 1, 0)), 1.25),
                Arguments.of(createLottoResult(listOf(3, 2, 1, 0, 0)), 1.0),
                Arguments.of(createLottoResult(listOf(2)), 0.0),
                Arguments.of(createLottoResult(listOf(1)), 0.0),
                Arguments.of(createLottoResult(listOf(0)), 0.0)
            )
        }

        @JvmStatic
        private fun createLottoResult(results: List<Int>): LottoResult {
            return LottoResult(results.map { LottoTicketMatchResult(it) }.toList())
        }
    }
}
