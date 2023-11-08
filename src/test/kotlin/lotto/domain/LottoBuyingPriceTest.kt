package lotto.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoBuyingPriceTest : StringSpec({

    "로또 구입 금액이 1000원 미만이면 예외가 발생한다." {
        // given
        val price = 999

        // expected
        shouldThrowWithMessage<IllegalArgumentException>("로또 구입 금액은 1000원 이상이어야 합니다.") {
            LottoBuyingPrice(price)
        }
    }

    "입력받은 값을 나눈다" {
        // given
        val price = 2000
        val lottoPrice = 1000
        val lottoBuyingPrice = LottoBuyingPrice(price)

        // when
        val result = lottoBuyingPrice.divide(lottoPrice)

        // then
        result shouldBe 2
    }

    "입력받은 값을 뺀다" {
        // given
        val price = 2000
        val lottoPrice = 1000
        val lottoBuyingPrice = LottoBuyingPrice(price)

        // when
        val result = lottoBuyingPrice.minus(lottoPrice)

        // then
        result shouldBe 1000
    }
})
