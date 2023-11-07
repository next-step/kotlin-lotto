package lotto_auto

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto_auto.lotto.LottoPrize

class LottoPrizeTest : FunSpec({
    test("getLottoPrize 함수가 제대로 된 등수를 리턴 한다") {
//        val list = listOf(
//            Pair(0, LottoPrize.MISS),
//            Pair(1, LottoPrize.MISS),
//            Pair(2, LottoPrize.MISS),
//            Pair(3, LottoPrize.FOURTH_PRIZE),
//            Pair(4, LottoPrize.THIRD_PRIZE),
//            Pair(5, LottoPrize.SECOND_PRIZE),
//            Pair(6, LottoPrize.FIRST_PRIZE),
//        )
//        withData(
//            list
//        ) { lottoPrize ->
//            LottoPrize.getLottoPrize(lottoPrize.first) shouldBe lottoPrize.second
//        }
        forAll(
            row(0, LottoPrize.MISS),
            row(1, LottoPrize.MISS),
            row(2, LottoPrize.MISS),
            row(3, LottoPrize.FOURTH_PRIZE),
            row(4, LottoPrize.THIRD_PRIZE),
            row(5, LottoPrize.SECOND_PRIZE),
            row(6, LottoPrize.FIRST_PRIZE),
        ) { count, prize ->
            LottoPrize.getLottoPrize(count) shouldBe prize
        }
    }
})
