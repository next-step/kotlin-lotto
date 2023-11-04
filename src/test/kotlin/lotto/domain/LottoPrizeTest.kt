package lotto.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class LottoPrizeTest : ExpectSpec({

    expect("일치하는 개수가 없으면 MISS를 반환한다.") {
        LottoPrize.from(0) shouldBe LottoPrize.MISS
    }
})
