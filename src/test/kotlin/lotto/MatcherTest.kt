package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

internal class MatcherTest : FreeSpec({

    "당첨 조건 목록과 당첨 번호를 통해 인스턴스틑 생성한다" {
        val winNumbers = WinNumbers(listOf(1, 2, 3, 4, 5, 6))
        val policies = listOf(
            WinPolicy(1, Money(100)),
            WinPolicy(2, Money(100)),
        )

        val matcher = Matcher(winNumbers, policies)

        matcher.shouldBeInstanceOf<Matcher>()
    }

    "당첨 조건 목록과 당첨 결과 목록의 개수가 일치한다" {
        val winNumbers = WinNumbers(listOf(1, 2, 3, 4, 5, 6))
        val policies = listOf(
            WinPolicy(4, Money(100)),
            WinPolicy(5, Money(200)),
        )
        val matcher = Matcher(winNumbers, policies)

        val results = matcher.makeResult()

        results shouldHaveSize policies.size
    }

    "당첨 결과는 숫자 일치개수의 오름차순으로 정렬한다" {
        val winNumbers = WinNumbers(listOf(1, 2, 3, 4, 5, 6))
        val policies = listOf(
            WinPolicy(4, Money(200)),
            WinPolicy(2, Money(100)),
            WinPolicy(5, Money(200)),
        )
        val matcher = Matcher(winNumbers, policies)

        val results = matcher.makeResult()

        results.map { it.matchCount } shouldBe listOf(2, 4, 5)
    }
})
