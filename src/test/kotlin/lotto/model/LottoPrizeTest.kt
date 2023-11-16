package lotto.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoPrizeTest : FunSpec({
    test("일치 번호 개수 별 당첨금 반환 테스트") {
        forAll(
            row(1, 0),
            row(2, 0),
            row(3, 5000),
            row(4, 50000),
            row(5, 150000),
            row(6, 2000000000)
        ) { matchedCount, answer ->
            val result = LottoPrize.of(matchedCount)

            result.prize shouldBe answer
        }
    }

    test("존재하지 않는 일치 번호 개수 전달 시 0 반환") {
        val answer = 0

        forAll(
            row(-1),
            row(7)
        ) { matchedCount ->
            val result = LottoPrize.of(matchedCount)

            result.prize shouldBe answer
        }
    }
})
