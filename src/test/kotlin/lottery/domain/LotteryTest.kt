package lottery.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class LotteryTest : StringSpec({
    "로또번호끼리의 일치 수를 반환한다" {
        table(
            headers("lotteryNumbers", "otherNumbers", "expected"),
            row(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 6), 6),
            row(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 32), 5),
            row(setOf(10, 11, 12, 13, 14, 15), setOf(15, 14, 13, 12, 40, 41), 4),
            row(setOf(31, 32, 3, 4, 5, 6), setOf(31, 32, 40, 41, 42, 43), 2),
        ).forAll { lotteryNumbers, others, expected ->
            val lottery = Lottery(LotteryNumbers(lotteryNumbers))
            val other = Lottery(LotteryNumbers(others))
            lottery.countMatchedNumber(other) shouldBe expected
        }
    }
})
