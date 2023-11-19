package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoPriceTest : StringSpec({

    "구입한 로또의 금액을 계산한다." {
        // given
        val lottoCount = LottoCount.from(10)

        // when
        val lottoPrice = LottoPrice.getTotalPrice(lottoCount)

        // then
        lottoPrice.value shouldBe 10000
    }
})
