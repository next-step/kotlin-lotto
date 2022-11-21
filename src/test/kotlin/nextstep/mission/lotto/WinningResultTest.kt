package nextstep.mission.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.reflection.compose
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.filter
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class WinningResultTest : StringSpec({

    "3,4,5,6 외 숫자를 전달해도 WiningResult의 모든 필드는 모두 0이다." {
        val arbitrary: Arb<Int> = Arb.int().filter { setOf(3, 4, 5, 6).contains(it).not() }

        checkAll(arbitrary) { count ->
            val winningResult = WinningResult()
            winningResult.increase(count)
            winningResult.threeMatch shouldBe 0
            winningResult.fourMatch shouldBe 0
            winningResult.fiveMatch shouldBe 0
            winningResult.sixMatch shouldBe 0
        }
    }

    "3,4,5,6 숫자를 전달하면 각각 수자의 매칭되는 필드의 값이 1 증가한다." {
        listOf(
            3 to listOf(1, 0, 0, 0),
            4 to listOf(0, 1, 0, 0),
            5 to listOf(0, 0, 1, 0),
            6 to listOf(0, 0, 0, 1),
        ).forEach { (count: Int, result: List<Int>) ->
            val winningResult = WinningResult()
            winningResult.increase(count)
            winningResult shouldBeWinningResult result
        }
    }

    "당첨 결과값에 따라 구매 비용 대비 수익률을 계산한다." {
        val winningResult = WinningResult(0, 0, 1, 0)
        winningResult.rateOfReturn(1_500_000) shouldBe 1
    }
})

infix fun WinningResult.shouldBeWinningResult(matchedCounts: List<Int>) =
    this shouldBe winningResultMatcher(matchedCounts[0], matchedCounts[1], matchedCounts[2], matchedCounts[3])

private fun winningResultMatcher(three: Int, four: Int, five: Int, six: Int) = Matcher.compose(
    matchedCountMatcher(three) to WinningResult::threeMatch,
    matchedCountMatcher(four) to WinningResult::fourMatch,
    matchedCountMatcher(five) to WinningResult::fiveMatch,
    matchedCountMatcher(six) to WinningResult::sixMatch,
)

private fun matchedCountMatcher(matchedCount: Int) = Matcher<Int> {
    MatcherResult(
        it == matchedCount,
        { "Age $it should be $matchedCount" },
        { "Age $it should not be $matchedCount" }
    )
}
