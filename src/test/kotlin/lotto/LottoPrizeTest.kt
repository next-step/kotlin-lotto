package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import lotto.lotto.LottoPrize

class LottoPrizeTest : FunSpec({
    context("getLottoPrize 함수가 제대로 된 등수를 리턴 한다 (2등 제외)") {
        val list = listOf(
            Pair(0, LottoPrize.MISS),
            Pair(1, LottoPrize.MISS),
            Pair(2, LottoPrize.MISS),
            Pair(3, LottoPrize.FIFTH_PRIZE),
            Pair(4, LottoPrize.FOURTH_PRIZE),
            Pair(5, LottoPrize.THIRD_PRIZE),
            Pair(6, LottoPrize.FIRST_PRIZE),
        )
        withData(
            list
        ) { lottoPrize ->
            LottoPrize.getLottoPrize(lottoPrize.first, false) shouldBe lottoPrize.second
        }
    }

    context("getLottoPrize 함수가 2등 을 잘 리턴한다") {
        LottoPrize.getLottoPrize(5, true) shouldBe LottoPrize.SECOND_PRIZE
    }
})
