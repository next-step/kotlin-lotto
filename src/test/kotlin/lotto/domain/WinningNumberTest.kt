package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

internal class WinningNumberTest : StringSpec({
    "6개의 숫자로 구성된 당첨 번호가 유효하지 못한 경우 예외가 발생한다." {
        val winningNumber = mutableListOf(1, 2, 3, 4, 5)
        val bonusNumber = LottoNumber.of(7)

        invalidLottoNumberString.forAll { (given: Int) ->
            winningNumber.add(given)
            val winningLotto = Lotto.of(winningNumber.toSet())

            shouldThrow<IllegalArgumentException> { WinningNumber.of(winningLotto, bonusNumber) }
        }
    }

    "보너스 번호가 유효하지 못한 경우 예외가 발생한다." {
        val winningLotto = Lotto.of(setOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.of(7)
        shouldThrow<IllegalArgumentException> {
            WinningNumber.of(winningLotto, bonusNumber)
        }
    }
}) {
    companion object {
        val invalidLottoNumberString = listOf(
            0 to "1~45 범위를 벗어나는 수",
            46 to "1~45 범위를 벗어나는수"
        )
    }
}
