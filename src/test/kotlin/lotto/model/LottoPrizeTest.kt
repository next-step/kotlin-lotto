package lotto.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoPrizeTest : FunSpec({
    test("일치 번호 개수 및 보너스 번호 당첨 여부 별 당첨금 반환 테스트") {
        forAll(
            row(1, false, 0),
            row(2, false, 0),
            row(3, false, 5_000),
            row(4, false, 50_000),
            row(5, false, 1_500_000),
            row(5, true, 30_000_000),
            row(6, false, 2_000_000_000)
        ) { matchedCount, isBonusNumberMatched, answer ->
            val result = LottoPrize.of(matchedCount, isBonusNumberMatched)

            result.prize shouldBe answer
        }
    }

    test("2등, 3등을 제외한 일치 번호 당첨금이 보너스 번호 당첨 여부와 관계 없이 정상적으로 반환하는지 테스트") {
        forAll(
            row(1, 0),
            row(2, 0),
            row(3, 5_000),
            row(4, 50_000),
            row(6, 2_000_000_000),
        ) { matchedCount, answer ->
            val result = LottoPrize.of(matchedCount, true)

            result.prize shouldBe answer
        }
    }
})
