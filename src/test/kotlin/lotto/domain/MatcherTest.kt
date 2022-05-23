package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

internal class MatcherTest : FreeSpec({

    "당첨 조건 목록과 당첨 번호를 통해 인스턴스를 생성한다" {
        val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val policies = listOf(
            WinPolicy(1, Money(100)),
            WinPolicy(2, Money(100)),
        )

        val matcher = Matcher(winNumbers, policies)

        matcher.shouldBeInstanceOf<Matcher>()
    }

    "당첨 조건 목록과 당첨 결과 목록의 개수가 일치한다" {
        val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val policies = listOf(
            WinPolicy(4, Money(100)),
            WinPolicy(5, Money(200)),
        )
        val matcher = Matcher(winNumbers, policies)

        val results = matcher.makeResult(emptyList())

        results shouldHaveSize policies.size
    }

    "당첨 결과는 숫자 일치개수의 오름차순으로 정렬한다" {
        val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val policies = listOf(
            WinPolicy(4, Money(200)),
            WinPolicy(2, Money(100)),
            WinPolicy(5, Money(200)),
        )
        val matcher = Matcher(winNumbers, policies)

        val results = matcher.makeResult(emptyList())

        results.map { it.matchCount } shouldBe listOf(2, 4, 5)
    }

    "각 당첨 조건에 해당하는 당첨 액수를 반환한다" {
        val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val policies = listOf(
            WinPolicy(4, Money(200)),
            WinPolicy(2, Money(100)),
            WinPolicy(5, Money(300)),
        )
        val matcher = Matcher(winNumbers, policies)

        val results = matcher.makeResult(emptyList())

        results.map { it.price } shouldBe listOf(Money(100), Money(200), Money(300))
    }

    "각 당첨 조건에 해당하는 당첨 회수를 계산한다" - {
        val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val policies = listOf(
            WinPolicy(5, Money(100)),
            WinPolicy(6, Money(300)),
        )
        val matcher = Matcher(winNumbers, policies)

        listOf(
            Triple(
                "5개 0회 6개 0회",
                listOf(
                    Lotto.of(listOf(1, 2, 3, 4, 7, 8)),
                    Lotto.of(listOf(3, 4, 5, 6, 7, 8)),
                ),
                listOf(0, 0),
            ),
            Triple(
                "5개 2회 6개 1회",
                listOf(
                    Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                    Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto.of(listOf(2, 3, 4, 5, 6, 7))
                ),
                listOf(2, 1),
            ),
        ).forEach { (title, lotto, expected) ->
            title {
                val results = matcher.makeResult(lotto)

                results.map { it.winCount } shouldBe expected
            }
        }
    }
})
