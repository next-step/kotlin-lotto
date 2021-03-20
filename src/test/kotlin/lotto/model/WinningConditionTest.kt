package lotto.model

import lotto.model.number.BonusNumber
import lotto.model.number.WinningNumbers
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinningConditionTest {
    @ParameterizedTest
    @MethodSource("winningAndBonusNumberProvider")
    fun `보너스 숫자와 당첨 숫자는 중복되지 않는다`(winningNumbers: WinningNumbers, bonusNumber: BonusNumber) {
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
                        WinningNumbers(listOf(1, 2, 3, 4, 5, 6)),
                        BonusNumber.get(1)
                    )
                }
            )
        }
    }
}
