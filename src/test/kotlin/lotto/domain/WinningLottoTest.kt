package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class WinningLottoTest : FunSpec({
    test("당첨번호를 입력받는다") {
        // Given
        val input = "1, 2, 3, 4, 5, 6"

        // When
        val winningLotto = WinningLotto(input, "7")

        // Then
        winningLotto.numbers.map { it.number } shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    test("당첨번호가 숫자가 아닌 경우 throw IllegalArgumentException") {
        val input = "1, 2, 3, 4, 5, a"

        shouldThrow<IllegalArgumentException> {
            WinningLotto(input)
        }
    }

    test("당첨번호가 중복된 경우 throw IllegalArgumentException") {
        val input = "1, 1, 2, 3, 4, 5"

        shouldThrow<IllegalArgumentException> {
            WinningLotto(input)
        }
    }

    test("보너스번호를 입력받는다.") {
        // Given
        val input = "1, 2, 3, 4, 5, 6"
        val bonus = "7"

        // When
        val winningLotto = WinningLotto(input, bonus)

        // Then
        winningLotto.bonusNumber.number shouldBe 7
    }
})
