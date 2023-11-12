package lotto.domain.purchase

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoCount

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
        val other = 1000
        val lottoBuyingPrice = LottoBuyingPrice(2000)

        // when
        val result = lottoBuyingPrice.divide(other)

        // then
        result shouldBe 2
    }

    "입력받은 값을 뺀다" {
        // given
        val other = 1000
        val lottoBuyingPrice = LottoBuyingPrice(2000)

        // when
        val result = lottoBuyingPrice.minus(other)

        // then
        result shouldBe 1000
    }

    "주어진 구입 금액으로 수동 로또를 구매할 수 없으면 예외가 발생한다." {
        // given
        val lottoBuyingPrice = LottoBuyingPrice(1000)
        val manualLottoCount = LottoCount(2)

        // when
        shouldThrowWithMessage<IllegalArgumentException>("주어진 구입 금액으로 수동 로또를 구매할 수 없습니다.") {
            lottoBuyingPrice.validateManualLottoPurchase(manualLottoCount)
        }
    }
})
