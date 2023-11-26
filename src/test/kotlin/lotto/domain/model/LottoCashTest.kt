package lotto.domain.model

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoCashTest : StringSpec({
    "로또 구입 금액을 전달하는 경우 숫자로 변환할 수 있다." {
        forAll(
            row(1000),
            row(14000),
        ) { number ->
            LottoCash(number).value shouldBe number
        }
    }

    "로또 구입 금액으로 음수를 전달하는 경우 IllegalArgumentException 예외를 던진다." {
        forAll(
            row(-1000),
            row(-100000),
        ) { number ->
            shouldThrowWithMessage<IllegalArgumentException>("숫자는 음수일 수 없습니다. value=$number") {
                LottoCash(number)
            }
        }
    }

    "로또를 구매하면 거스름돈을 받을 수 있다." {
        val lottoCash = LottoCash(14000)
        lottoCash.purchase(1000).value shouldBe 13000
    }
})
