package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningNumbersTest : StringSpec({
    "당첨 번호는 ,를 구분자로 생성할 수 있다" {
        shouldNotThrowAny {
            WinningNumbers("1,2,3,4,5,6")
        }
    }

    "당첨 번호는 6개여야한다" {
        shouldThrow<IllegalArgumentException> {
            WinningNumbers("1,2,3,4,5,6,7")
        }
    }

    "번호가 당첨되었는지 확인할 수 있다" {
        val winningNumbers = WinningNumbers("1,2,3,4,5,6")
        val lotto = Lotto("1,2,3,4,5,6")

        val matchCount = winningNumbers.rank(lotto)
        matchCount shouldBe 6
    }
})
