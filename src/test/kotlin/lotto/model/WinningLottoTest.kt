package lotto.model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource


class WinningLottoTest {
    private val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6).toLottoNumber(), LottoNumber.from(7))

    @DisplayName("순위별 결과 테스트")
    @ParameterizedTest()
    @MethodSource("provideTickets")
    fun lottoResultTest(arguments: Pair<List<LottoTicket>, Prize>) {
        val (values, expectedResult) = arguments
        val lottoResult = winningLotto.getLottoResult(values)
        lottoResult.results shouldBe mapOf(expectedResult to 1)
    }

    companion object {
        @JvmStatic
        fun provideTickets(): List<Pair<List<LottoTicket>, Prize>> = listOf(
            Pair(listOf(1, 2, 3, 4, 5, 6).toLottoNumber().toLottoTickets(), Prize.FIRST),
            Pair(listOf(1, 2, 3, 4, 5, 7).toLottoNumber().toLottoTickets(), Prize.SECOND),
            Pair(listOf(1, 2, 3, 4, 5, 8).toLottoNumber().toLottoTickets(), Prize.THIRD)
        )

        private fun List<Int>.toLottoNumber(): List<LottoNumber> {
            return this.map { LottoNumber.from(it) }
        }

        private fun List<LottoNumber>.toLottoTickets(): List<LottoTicket> {
            return listOf(LottoTicket(this))
        }
    }
}
