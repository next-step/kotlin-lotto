package lotto.model

import lotto.model.number.BonusNumber
import lotto.model.number.WinningNumbers
import lotto.model.WinningPlace.FIRST
import lotto.model.WinningPlace.SECOND
import lotto.model.WinningPlace.THIRD
import lotto.model.WinningPlace.FOURTH
import lotto.model.WinningPlace.FIFTH
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinningCounterTest {
    @Test
    fun `인자로 주어진 counter 를 그대로 사용하지 않는다`() {
        val paramCounter = mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 0)

        val result1 = WinningCounter(paramCounter)
        paramCounter[FIRST] = 1
        val result2 = WinningCounter(paramCounter)

        assertThat(result1).isNotEqualTo(result2)
    }

    @ParameterizedTest
    @MethodSource("winningCounterProvider")
    fun `당첨 번호를 입력 받아서 알맞은 WinningCounter 를 반환한다`(
        winningNumbers: WinningNumbers,
        bonusNumbers: BonusNumber,
        lottoTickets: LottoTickets,
        winningCounter: WinningCounter
    ) {
        val result = WinningCounter(lottoTickets, WinningCondition(winningNumbers, bonusNumbers))

        assertThat(result).isEqualTo(winningCounter)
    }

    companion object {
        @JvmStatic
        fun winningCounterProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        WinningNumbers(listOf(1, 2, 3, 4, 5, 6)),
                        BonusNumber.get(7),
                        LottoTickets(listOf(LottoTicket(listOf(7, 8, 9, 10, 11, 12)))),
                        WinningCounter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 0))
                    )
                },
                Arguments {
                    arrayOf(
                        WinningNumbers(listOf(1, 2, 3, 4, 5, 6)),
                        BonusNumber.get(7),
                        LottoTickets(listOf(LottoTicket(listOf(1, 2, 3, 10, 11, 12)))),
                        WinningCounter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 1))
                    )
                },
                Arguments {
                    arrayOf(
                        WinningNumbers(listOf(1, 2, 3, 4, 5, 6)),
                        BonusNumber.get(7),
                        LottoTickets(
                            listOf(
                                LottoTicket(listOf(1, 2, 3, 10, 11, 12)),
                                LottoTicket(listOf(1, 2, 3, 4, 11, 12))
                            )
                        ),
                        WinningCounter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 1, FIFTH to 1))
                    )
                },
                Arguments {
                    arrayOf(
                        WinningNumbers(listOf(1, 2, 3, 4, 5, 6)),
                        BonusNumber.get(7),
                        LottoTickets(
                            listOf(
                                LottoTicket(listOf(1, 2, 3, 4, 5, 7)),
                                LottoTicket(listOf(1, 2, 3, 4, 5, 12))
                            )
                        ),
                        WinningCounter(mutableMapOf(FIRST to 0, SECOND to 1, THIRD to 1, FOURTH to 0, FIFTH to 0))
                    )
                }
            )
        }
    }
}
