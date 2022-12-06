package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
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
})
