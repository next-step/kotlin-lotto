package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class WinningNumbersTest : BehaviorSpec({
    given("당첨번호와") {
        val winningNumbers = WinningNumbers(LottoNumber(listOf(2, 5, 6, 14, 25, 38)))

        `when`("구매한 번호를 비교하여") {
            val buyingNumbers = LottoNumber(listOf(2, 5, 6, 30, 31, 32))

            then("일치하는 숫자의 개수를 반환한다.") {
                winningNumbers.getSumMatchingNumbers(buyingNumbers) shouldBe 3
            }
        }
    }
})
