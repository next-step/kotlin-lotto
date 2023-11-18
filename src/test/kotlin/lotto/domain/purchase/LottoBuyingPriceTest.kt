package lotto.domain.purchase

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoCount

class LottoBuyingPriceTest : StringSpec({

    "로또 구입 금액이 1000원 미만이면 실패를 반환한다." {
        // given
        val price = 999

        // when
        val result = LottoBuyingPrice.createResult(price)

        // then
        result shouldBe LottoBuyingPriceResult.Failure("로또 구입 금액은 1000원 이상이어야 합니다.")
    }

    "입력받은 값을 나눈다" {
        // given
        val other = 1000
        val buyingPriceResult = LottoBuyingPrice.createResult(2000)
        val lottoBuyingPrice = buyingPriceResult as LottoBuyingPriceResult.Success

        // when
        val result = lottoBuyingPrice.data.divide(other)

        // then
        result shouldBe 2
    }

    "입력받은 값을 뺀다" {
        // given
        val other = 1000
        val buyingPriceResult = LottoBuyingPrice.createResult(2000)
        val lottoBuyingPrice = buyingPriceResult as LottoBuyingPriceResult.Success

        // when
        val result = lottoBuyingPrice.data.minus(other)

        // then
        result shouldBe 1000
    }

    "주어진 구입 금액으로 수동 로또를 구매할 수 없으면 실패를 반환한다." {
        // given
        val buyingPriceResult = LottoBuyingPrice.createResult(1000)
        val lottoBuyingPrice = buyingPriceResult as LottoBuyingPriceResult.Success
        val manualLottoCount = LottoCount.from(2)

        // when
        val result = lottoBuyingPrice.data.validateManualLottoPurchase(manualLottoCount)

        // then
        result shouldBe LottoBuyingPriceResult.Failure("주어진 구입 금액으로 수동 로또를 구매할 수 없습니다.")
    }
})
