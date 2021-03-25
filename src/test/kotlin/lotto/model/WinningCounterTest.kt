package lotto.model

import lotto.model.number.WinningNumbers
import lotto.model.WinningPlace.FIRST
import lotto.model.WinningPlace.SECOND
import lotto.model.WinningPlace.THIRD
import lotto.model.WinningPlace.FOURTH
import lotto.model.WinningPlace.FIFTH
import lotto.model.number.WinningNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinningCounterTest {
    @Test
    fun `인자로 주어진 counter 를 그대로 사용하지 않는다`() {
        val paramCounter = mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 0)

        val result1 = WinningCounter.Builder(winningCondition).counter(paramCounter).build()
        paramCounter[FIRST] = 1
        val result2 = WinningCounter.Builder(winningCondition).counter(paramCounter).build()

        assertThat(result1).isNotEqualTo(result2)
    }

    @ParameterizedTest
    @MethodSource("winningCounterProvider")
    fun `당첨 번호를 입력 받아서 알맞은 WinningCounter 를 반환한다`(
        lottoTickets: LottoTickets,
        winningCounter: WinningCounter
    ) {
        val result = WinningCounter.Builder(winningCondition).build()

        lottoTickets.forEach {
            result.record(it)
        }

        assertThat(result).isEqualTo(winningCounter)
    }

    companion object {
        private val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        private val bonusNumber = WinningNumber.get(7)
        private val winningCondition = WinningCondition(winningNumbers, bonusNumber)

        @JvmStatic
        fun winningCounterProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        LottoTickets(listOf(LottoTicket(listOf(7, 8, 9, 10, 11, 12)))),
                        WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 0)).build()
                    )
                },
                Arguments {
                    arrayOf(
                        LottoTickets(listOf(LottoTicket(listOf(1, 2, 3, 10, 11, 12)))),
                        WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 1)).build()
                    )
                },
                Arguments {
                    arrayOf(
                        LottoTickets(
                            listOf(
                                LottoTicket(listOf(1, 2, 3, 10, 11, 12)),
                                LottoTicket(listOf(1, 2, 3, 4, 11, 12))
                            )
                        ),
                        WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 1, FIFTH to 1)).build()
                    )
                },
                Arguments {
                    arrayOf(
                        LottoTickets(
                            listOf(
                                LottoTicket(listOf(1, 2, 3, 4, 5, 7)),
                                LottoTicket(listOf(1, 2, 3, 4, 5, 12))
                            )
                        ),
                        WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 1, THIRD to 1, FOURTH to 0, FIFTH to 0)).build()
                    )
                }
            )
        }
    }
}
