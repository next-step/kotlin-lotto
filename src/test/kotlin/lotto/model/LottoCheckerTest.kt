package lotto.model

import lotto.model.LottoPlace.FIRST
import lotto.model.LottoPlace.SECOND
import lotto.model.LottoPlace.THIRD
import lotto.model.LottoPlace.FOURTH
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoCheckerTest {
    @ParameterizedTest
    @MethodSource("lottoResultProvider")
    fun `당첨 번호를 입력 받아서 알맞은 LottoResult 를 반환한다`(winningNumbers: WinningNumbers, lottoTickets: LottoTickets, sumCostOfTickets: Money, lottoResult: LottoResult) {
        val result = LottoChecker(winningNumbers).check(lottoTickets, sumCostOfTickets)

        assertThat(result).isEqualTo(lottoResult)
    }

    companion object {
        @JvmStatic
        fun lottoResultProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6)),
                        LottoTickets(listOf(LottoTicket.from(listOf(7, 8, 9, 10, 11, 12)))),
                        Money(10_000),
                        LottoResult(WinningCounter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0)), Money(10_000))
                    )
                },
                Arguments {
                    arrayOf(
                        WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6)),
                        LottoTickets(listOf(LottoTicket.from(listOf(1, 2, 3, 10, 11, 12)))),
                        Money(10_000),
                        LottoResult(WinningCounter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 1)), Money(10_000))
                    )
                },
                Arguments {
                    arrayOf(
                        WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6)),
                        LottoTickets(listOf(LottoTicket.from(listOf(1, 2, 3, 10, 11, 12)), LottoTicket.from(listOf(1, 2, 3, 4, 11, 12)))),
                        Money(20_000),
                        LottoResult(WinningCounter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 1, FOURTH to 1)), Money(20_000))
                    )
                }
            )
        }
    }
}
