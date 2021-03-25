package lotto.model

import lotto.model.number.WinningNumber
import lotto.model.number.WinningNumbers
import lotto.model.number.WinningNumbersFactory
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinningConditionTest {
    @ParameterizedTest
    @MethodSource("winningAndBonusNumberProvider")
    fun `보너스 숫자와 당첨 숫자는 중복되지 않는다`(winningNumbers: WinningNumbers, bonusNumber: WinningNumber) {
        assertThrows<IllegalArgumentException> {
            WinningCondition(winningNumbers, bonusNumber)
        }
    }

    companion object {
        @JvmStatic
        fun winningAndBonusNumberProvider(): List<Arguments> {
            return listOf(
                Arguments {
                    arrayOf(
                        WinningNumbersFactory.create(listOf(1, 2, 3, 4, 5, 6)),
                        WinningNumber.get(1)
                    )
                }
            )
        }
    }
}
