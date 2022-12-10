package step2.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

internal class WinningNumberTest : StringSpec({
    "유효하지 못한 값인 경우 예외가 발생한다." {
        val winningNumber = mutableListOf("1", "2", "3", "4", "5")
        invalidLottoNumberString.forAll { (given: String) ->
            winningNumber.add(given)
            shouldThrow<IllegalArgumentException> { WinningNumber.ofStrings(winningNumber) }
        }
    }
}) {
    companion object {
        val invalidLottoNumberString = listOf(
            "" to "빈값",
            " " to "공백",
            "a" to "숫자가 아닌 값",
            "-1" to "음수",
            "0" to "1~45 범위를 벗어나는 수",
            "46" to "1~45 범위를 벗어나는수",
        )
    }
}
