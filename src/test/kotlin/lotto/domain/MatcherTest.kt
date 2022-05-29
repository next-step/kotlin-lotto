package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import lotto.extension.autoOf

internal class MatcherTest : FreeSpec({
    val winNumbers = WinNumbers.of(listOf(1, 2, 3, 4, 5, 6), 7)

    "당첨 조건 목록과 당첨 번호를 통해 인스턴스를 생성한다" {
        val policies = listOf(
            WinPolicy(matchCount = 1, priceAmount = Money(100)),
            WinPolicy(matchCount = 2, priceAmount = Money(100)),
        )

        val matcher = Matcher(winNumbers, policies)

        matcher.shouldBeInstanceOf<Matcher>()
    }

    "당첨 조건 목록과 당첨 결과 목록의 개수가 일치한다" {
        val policies = listOf(
            WinPolicy(matchCount = 4, priceAmount = Money(200)),
            WinPolicy(matchCount = 5, priceAmount = Money(200)),
        )
        val matcher = Matcher(winNumbers, policies)

        val results = matcher.makeResult(emptyList())

        results shouldHaveSize policies.size
    }

    "당첨 결과는 숫자 일치개수의 오름차순으로 정렬한다" {
        val policies = listOf(
            WinPolicy(matchCount = 4, priceAmount = Money(200)),
            WinPolicy(matchCount = 2, priceAmount = Money(150), useBonus = true),
            WinPolicy(matchCount = 2, priceAmount = Money(100)),
            WinPolicy(matchCount = 5, priceAmount = Money(300)),
        )
        val matcher = Matcher(winNumbers, policies)

        val results = matcher.makeResult(emptyList())

        results.map { it.matchCount } shouldBe listOf(2, 2, 4, 5)
        results.map { it.price } shouldBe listOf(
            Money(100), Money(150), Money(200), Money(300)
        )
    }

    "각 당첨 조건에 해당하는 당첨 액수를 반환한다" {
        val policies = listOf(
            WinPolicy(matchCount = 4, priceAmount = Money(200)),
            WinPolicy(matchCount = 2, priceAmount = Money(100)),
            WinPolicy(matchCount = 5, priceAmount = Money(300)),
        )
        val matcher = Matcher(winNumbers, policies)

        val results = matcher.makeResult(emptyList())

        results.map { it.price } shouldBe listOf(Money(100), Money(200), Money(300))
    }

    "각 당첨 조건에 해당하는 당첨 회수를 계산한다" - {
        val policies = listOf(
            WinPolicy(matchCount = 5, priceAmount = Money(100)),
            WinPolicy(matchCount = 6, priceAmount = Money(300)),
        )
        val matcher = Matcher(winNumbers, policies)

        listOf(
            Triple(
                "5개 0회 6개 0회",
                listOf(
                    Lotto.autoOf(1, 2, 3, 4, 7, 8),
                    Lotto.autoOf(3, 4, 5, 6, 7, 8),
                ),
                listOf(0, 0),
            ),
            Triple(
                "5개 2회 6개 1회",
                listOf(
                    Lotto.autoOf(1, 2, 3, 4, 5, 7),
                    Lotto.autoOf(1, 2, 3, 4, 5, 6),
                    Lotto.autoOf(2, 3, 4, 5, 6, 7)
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

    "보너스 볼을 고려한 당첨 회수를 계산한다" {
        val policies = listOf(
            WinPolicy(matchCount = 4, priceAmount = Money(100), useBonus = true),
        )
        val matcher = Matcher(winNumbers, policies)
        val lottos = listOf(
            Lotto.autoOf(2, 3, 4, 5, 7, 8),
            Lotto.autoOf(2, 3, 4, 5, 8, 9),
        )

        val results = matcher.makeResult(lottos)

        results.first().winCount shouldBe 1
    }
})
