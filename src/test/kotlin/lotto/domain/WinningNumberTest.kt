package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

internal class WinningNumberTest : StringSpec({
    "6개의 숫자로 구성된 당첨 번호 중 1~45 범위의 숫자가 아닌 경우 예외가 발생한다." {
        val winningNumber = mutableListOf(1, 2, 3, 4, 5)
        val bonusNumber = 7

        outOfLottoRangeNumber.forAll { (given: Int) ->
            winningNumber.add(given)
            shouldThrow<IllegalArgumentException> {
                WinningNumber.of(winningNumber.toSet(), bonusNumber)
            }
        }
    }

    "보너스 번호가 1~45 범위의 숫자가 아닌 경우 예외가 발생한다." {
        val winningLotto = setOf(1, 2, 3, 4, 5, 6)
        outOfLottoRangeNumber.forAll { (given: Int) ->
            shouldThrow<IllegalArgumentException> {
                WinningNumber.of(winningLotto, given)
            }
        }
    }

    "보너스 번호가 6개의 숫자고 구성된 당첨 번호와 중복 되는 경우 예외가 발생한다." {
        val given = 1
        val winningLotto = setOf(given, 2, 3, 4, 5, 6)
        shouldThrow<IllegalArgumentException> {
            WinningNumber.of(winningLotto, given)
        }
    }
}) {
    companion object {
        val outOfLottoRangeNumber = listOf(
            0 to "1~45 범위를 벗어나는 수",
            46 to "1~45 범위를 벗어나는수"
        )
    }
}
