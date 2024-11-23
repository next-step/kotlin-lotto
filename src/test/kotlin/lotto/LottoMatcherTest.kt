package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoMatcher

class LottoMatcherTest : FunSpec({
    test("로또 번호가 일치하는 개수를 반환한다.") {
        // given
        val givenWinningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val testCases =
            table(
                headers("pickNumbers", "matchedCount"),
                row(listOf(11, 12, 13, 14, 15, 16), 0),
                row(listOf(1, 12, 13, 14, 15, 16), 1),
                row(listOf(1, 2, 13, 14, 15, 16), 2),
                row(listOf(1, 2, 3, 14, 15, 16), 3),
                row(listOf(1, 2, 3, 4, 15, 16), 4),
                row(listOf(1, 2, 3, 4, 5, 16), 5),
                row(listOf(1, 2, 3, 4, 5, 6), 6),
            )

        forAll(testCases) { pickNumbers, matchedCount ->
            // when
            val result = LottoMatcher.match(listOf(Lotto.of(pickNumbers)), givenWinningNumbers)

            // then
            result.first().matchCount shouldBe matchedCount
        }
    }
})
