package lotto.model.winning

import lotto.model.LottoTicket
import lotto.model.LottoTickets
import lotto.model.winning.WinningPlace.FIRST
import lotto.model.winning.WinningPlace.SECOND
import lotto.model.winning.WinningPlace.THIRD
import lotto.model.winning.WinningPlace.FOURTH
import lotto.model.winning.WinningPlace.FIFTH
import lotto.model.winning.WinningPlace.MISS
import lotto.model.number.LottoNumber
import lotto.model.number.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinningCounterTest {
    @ParameterizedTest
    @MethodSource("winningCounterProvider")
    fun `당첨 번호를 입력 받아서 알맞은 WinningCounter 를 반환한다`(
        lottoTickets: LottoTickets,
        winningCounter: WinningCounter
    ) {
        val result = WinningCounter(lottoTickets, winningCondition)

        assertThat(result).isEqualTo(winningCounter)
    }

    companion object {
        private val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        private val bonusNumber = LottoNumber.get(7)
        private val winningCondition = WinningCondition(winningNumbers, bonusNumber)

        @JvmStatic
        fun winningCounterProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        LottoTickets(
                            LottoTicket(7, 8, 9, 10, 11, 12)
                        ),
                        WinningCounter(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 0, MISS to 1)
                    )
                },
                Arguments {
                    arrayOf(
                        LottoTickets(
                            LottoTicket(1, 2, 3, 10, 11, 12)
                        ),
                        WinningCounter(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 1, MISS to 0)
                    )
                },
                Arguments {
                    arrayOf(
                        LottoTickets(
                            LottoTicket(1, 2, 3, 10, 11, 12),
                            LottoTicket(1, 2, 3, 4, 11, 12)
                        ),
                        WinningCounter(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 1, FIFTH to 1, MISS to 0)
                    )
                },
                Arguments {
                    arrayOf(
                        LottoTickets(
                            LottoTicket(1, 2, 3, 4, 5, 7),
                            LottoTicket(1, 2, 3, 4, 5, 12)
                        ),
                        WinningCounter(FIRST to 0, SECOND to 1, THIRD to 1, FOURTH to 0, FIFTH to 0, MISS to 0)
                    )
                }
            )
        }
    }
}
