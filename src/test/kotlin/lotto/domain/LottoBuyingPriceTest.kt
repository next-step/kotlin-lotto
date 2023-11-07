package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class LottoBuyingPriceTest : StringSpec({

    "로또 구입 금액이 1000원 미만이면 예외가 발생한다." {
        val price = 999

        shouldThrowWithMessage<IllegalArgumentException>("로또 구입 금액은 1000원 이상이어야 합니다.") {
            LottoBuyingPrice(price)
        }
    }
})
