package lotto.step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import lotto.step3.domain.LottoNumberPicker
import lotto.step3.domain.LottoPurchaseManager

class LottoPurchaseManagerTest : FunSpec({
    test("금액을 입력하면 구매 가능한 로또 개수를 반환한다.") {
        // given
        val testCases =
            table(
                headers("input", "expected"),
                row(500L, 0L),
                row(1000L, 1L),
                row(1999L, 1L),
                row(14000L, 14L),
                row(14000L, 14L),
                row(14300L, 14L),
                row(14500L, 14L),
                row(14999L, 14L),
            )

        // when
        val lottoPurchaseManager = LottoPurchaseManager(LottoNumberPicker())
        forAll(testCases) { money, expected ->
            // then
            lottoPurchaseManager.purchase(money).size shouldBe expected
        }
    }

    test("구매한 로또는 번호가 랜덤으로 중복되지 않는 6개의 숫자를 자동 배정한다.") {
        // given
        val testCases =
            table(
                headers("input"),
                row(500L),
                row(1000L),
                row(1999L),
                row(14000L),
                row(14000L),
                row(14300L),
                row(14500L),
                row(14999L),
            )

        // when
        val lottoPurchaseManager = LottoPurchaseManager(LottoNumberPicker())
        forAll(testCases) { money ->
            // then
            lottoPurchaseManager.purchase(money).forEach {
                it.numbers.distinct().size shouldBe 6
            }
        }
    }
})
