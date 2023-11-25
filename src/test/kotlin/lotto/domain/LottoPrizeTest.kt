package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoPrizeTest : FunSpec({

    test("일치하는 번호수와, 보너스번호 일치여부를 통해 로또 등수를 확인할 수 있다.") {
        LottoPrize.of(6, true) shouldBe LottoPrize.FIRST
        LottoPrize.of(6, false) shouldBe LottoPrize.FIRST

        LottoPrize.of(5, true) shouldBe LottoPrize.SECOND
        LottoPrize.of(5, false) shouldBe LottoPrize.THIRD

        LottoPrize.of(4, true) shouldBe LottoPrize.FOURTH
        LottoPrize.of(4, false) shouldBe LottoPrize.FOURTH

        LottoPrize.of(3, true) shouldBe LottoPrize.FIFTH
        LottoPrize.of(3, false) shouldBe LottoPrize.FIFTH

        LottoPrize.of(2, true) shouldBe LottoPrize.MISS
        LottoPrize.of(2, false) shouldBe LottoPrize.MISS
        LottoPrize.of(1, true) shouldBe LottoPrize.MISS
        LottoPrize.of(1, false) shouldBe LottoPrize.MISS
        LottoPrize.of(0, true) shouldBe LottoPrize.MISS
        LottoPrize.of(0, false) shouldBe LottoPrize.MISS
    }
})
