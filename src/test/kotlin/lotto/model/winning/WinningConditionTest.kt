package lotto.model.winning

import lotto.model.number.LottoNumber
import lotto.model.number.LottoNumbers
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinningConditionTest {
    @ParameterizedTest
    @MethodSource("winningAndBonusNumberProvider")
    fun `보너스 숫자와 당첨 숫자는 중복되지 않는다`(winningNumbers: LottoNumbers, bonusNumber: LottoNumber) {
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
                        LottoNumbers(1, 2, 3, 4, 5, 6),
                        LottoNumber.get(1)
                    )
                }
            )
        }
    }
}
