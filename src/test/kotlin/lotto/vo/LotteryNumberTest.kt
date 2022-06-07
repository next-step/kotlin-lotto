package lotto.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

internal class LotteryNumberTest : StringSpec({

    "1~45 범위를 벗어난 숫자를 생성할 경우 예외를 생성한다." {
        listOf(0, 46).forAll { lotteryNumber ->
            shouldThrow<IllegalArgumentException> {
                LotteryNumber(lotteryNumber)
            }
        }
    }
})
