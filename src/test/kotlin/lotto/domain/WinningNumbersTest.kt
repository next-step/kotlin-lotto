package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import java.lang.IllegalArgumentException

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

    given("입력된 당첨 번호들이") {
        `when`("숫자로 변환될 수 없으면") {
            val input = "a, b, c, d, 5, 6"

            then("IllegalArgumentException 을 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    WinningNumbers.from(input)
                }
                exception.message should startWith("당첨 번호는 숫자만 입력할 수 있습니다.")
            }
        }

        `when`("1 ~ 45 사이의 숫자가 아니라면") {
            val inputList = listOf(
                "0, 1, 4, 5, 8, 10",
                "3, 20, 444, -7, 1, 9",
                "111, 9, 90, 8, 23, 1"
            )
            inputList.forAll {
                then("IllegalArgumentException 을 반환한다.") {
                    val exception = shouldThrow<IllegalArgumentException> {
                        WinningNumbers.from(it)
                    }
                    exception.message should startWith("당첨 번호는 1 ~ 45 사이의 숫자여야 합니다.")
                }
            }
        }

        `when`("6개의 숫자가 아니라면") {
            val input = "1, 2, 3, 4, 5, 6, 7"

            then("IllegalArgumentException 을 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    WinningNumbers.from(input)
                }
                exception.message should startWith("당첨 번호는 6개의 숫자여야 합니다.")
            }
        }

        `when`("중복된 수가 존재한다면") {
            val input = "1, 2, 2, 4, 2, 2"

            then("IllegalArgumentException 을 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    WinningNumbers.from(input)
                }
                exception.message should startWith("당첨 번호는 중복될 수 없습니다.")
            }
        }
    }
})
