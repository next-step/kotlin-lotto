package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class WinningNumbersTest : FunSpec({
    context("객체 생성") {
        test("6개의 당첨 번호, 보너스 번호를 입력받아 객체를 생성한다.") {
            shouldNotThrowAny {
                WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
            }
        }
        test("보너스 번호가 6개의 당첨 번호와 하나라도 중복될 경우, 예외가 발생한다.") {
            val actual = shouldThrow<IllegalArgumentException> {
                WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6)
            }

            actual.message should startWith("bonus number should be different number out of winning numbers")
        }
    }
    context("matchPrize()") {
        test("로또 번호와 비교하여 일치하는 우승 상금 객체를 반환한다.") {
            val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

            table(
                headers("winningNumbers", "lottoNumbers", "expectedResult"),
                row(winningNumbers, LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), WinningPrize.FIRST_PRIZE),
                row(winningNumbers, LottoNumbers(listOf(1, 2, 3, 4, 5, 7)), WinningPrize.SECOND_PRIZE),
                row(winningNumbers, LottoNumbers(listOf(1, 2, 3, 4, 5, 8)), WinningPrize.THIRD_PRIZE),
                row(winningNumbers, LottoNumbers(listOf(1, 2, 3, 4, 8, 7)), WinningPrize.FOURTH_PRIZE),
                row(winningNumbers, LottoNumbers(listOf(1, 2, 3, 9, 8, 7)), WinningPrize.FIFTH_PRIZE),
                row(winningNumbers, LottoNumbers(listOf(1, 2, 10, 9, 8, 7)), WinningPrize.NONE)
            ).forAll { winningNumbers, lottoNumbers, expectedResult ->
                winningNumbers.matchPrize(lottoNumbers) shouldBe expectedResult
            }
        }
    }
})
