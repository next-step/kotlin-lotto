package lotto.model

import lotto.model.WinningPlace.FIRST
import lotto.model.WinningPlace.SECOND
import lotto.model.WinningPlace.THIRD
import lotto.model.WinningPlace.FOURTH
import lotto.model.WinningPlace.FIFTH
import lotto.model.number.WinningNumber
import lotto.model.number.WinningNumbersFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class LottoResultTest {
    @ParameterizedTest
    @MethodSource("lottoResultProvider")
    fun `총 구매비용과 등수별 당첨 횟수가 같으면 같은 LottoResult 이다`(result: LottoResult, otherResult: LottoResult, isEqual: Boolean) {
        assertThat(result == otherResult).isEqualTo(isEqual)
    }

    @ParameterizedTest
    @MethodSource("benefitRateProvider")
    fun `주어진 값을 이용해 수익률을 구한다`(result: LottoResult, benefitRate: Double) {
        assertThat(result.benefitRate).isEqualTo(benefitRate)
    }

    companion object {
        private val winningNumbers = WinningNumbersFactory.create(listOf(1, 2, 3, 4, 5, 6))
        private val bonusNumber = WinningNumber.get(7)
        private val winningCondition = WinningCondition(winningNumbers, bonusNumber)

        @JvmStatic
        fun lottoResultProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 1, THIRD to 1, FOURTH to 0, FIFTH to 0)).build(), Money(10_000)),
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 1, THIRD to 1, FOURTH to 0, FIFTH to 0)).build(), Money(10_000)),
                        true
                    )
                },
                Arguments {
                    arrayOf(
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 1, THIRD to 1, FOURTH to 0, FIFTH to 0)).build(), Money(10_000)),
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 1, SECOND to 1, THIRD to 0, FOURTH to 0, FIFTH to 0)).build(), Money(10_000)),
                        false
                    )
                },
                Arguments {
                    arrayOf(
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 1, THIRD to 1, FOURTH to 0, FIFTH to 0)).build(), Money(10_000)),
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 1, THIRD to 1, FOURTH to 0, FIFTH to 0)).build(), Money(23_000)),
                        false
                    )
                }
            )
        }

        @JvmStatic
        fun benefitRateProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 1)).build(), Money(5_000)),
                        1.0
                    )
                },
                Arguments {
                    arrayOf(
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 0)).build(), Money(5_000)),
                        0.0
                    )
                },
                Arguments {
                    arrayOf(
                        LottoResult(WinningCounter.Builder(winningCondition).counter(mutableMapOf(FIRST to 0, SECOND to 0, THIRD to 0, FOURTH to 0, FIFTH to 1)).build(), Money(14_000)),
                        0.35
                    )
                }
            )
        }
    }
}
