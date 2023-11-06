package lotto.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class LottoPrizeTest : ExpectSpec({

    expect("일치하는 개수가 없으면 MISS를 반환한다.") {
        LottoPrize.from(0, false) shouldBe LottoPrize.MISS
    }

    context("일치하는 개수가 5개인 경우") {
        expect("보너스 번호가 일치하는 경우 SECOND를 반환한다.") {
            LottoPrize.from(5, true) shouldBe LottoPrize.SECOND
        }

        expect("보너스 번호가 일치하지 않는 경우 THIRD를 반환한다.") {
            LottoPrize.from(5, false) shouldBe LottoPrize.THIRD
        }
    }
})
