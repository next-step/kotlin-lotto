package lotto.domain.lottery

import io.kotest.assertions.throwables.shouldNotThrowAnyUnit
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.throwable.shouldHaveMessage

class LotteryNumberTest : StringSpec({
    "로또의 숫자가 1이상 45 이하인 경우" {
        forAll(
            row(1),
            row(45)

        ) {
            shouldNotThrowAnyUnit {
                LotteryNumber(1)
            }
        }
    }

    "로또의 숫자가 1이상 45 이하가 아닌 경우" {
        forAll(
            row(0),
            row(46)

        ) {
            shouldThrow<IllegalArgumentException> {
                LotteryNumber(it)
            }.shouldHaveMessage("로또의 숫자는 1~45 사이의 정수가 가능합니다.")
        }
    }
})
