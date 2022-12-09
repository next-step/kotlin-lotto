package step2.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class LottoTest : StringSpec({
    "로또 한게임과 당첨번호를 비교하여 당첨 결과를 판별한다." {
        val given = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        winningNumber.forAll { (winningNumber: List<Int>, expected: Int) ->
            val actual = given.match(WinningNumber.of(winningNumber))
            actual shouldBe expected
        }
    }

    "중복된 번호가 포함되는 경우 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Lotto.of(listOf(1, 1, 1, 1, 1, 1))
        }
    }
}) {
    companion object {
        val winningNumber = listOf(
            listOf(1, 2, 3, 4, 5, 6) to 6,
            listOf(1, 2, 3, 4, 5, 7) to 5,
            listOf(1, 2, 3, 4, 7, 8) to 4,
            listOf(1, 2, 3, 7, 8, 9) to 3,
            listOf(1, 2, 7, 8, 9, 10) to 2,
            listOf(1, 7, 8, 9, 10, 11) to 1,
            listOf(7, 8, 9, 10, 11, 12) to 0,
        )
    }
}
