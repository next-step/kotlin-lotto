package lotto.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMatchResult
import lotto.domain.Money

internal class ResultViewTest : StringSpec({

    "당첨 통계 문구를 출력한다" {
        val output = StubOutput()
        val view = ResultView(output)
        val results = listOf(LottoMatchResult(1, Money(100), 3))

        view.print(results)

        output.printed.take(2) shouldBe listOf("당첨 통계", "---------")
    }

    "주어진 당첨 결과에 따른 통계를 출력한다" {
        val output = StubOutput()
        val view = ResultView(output)
        val results = listOf(
            LottoMatchResult(3, Money(1000), 2),
            LottoMatchResult(4, Money(2000), 0),
            LottoMatchResult(5, Money(3000), 1),
        )

        view.print(results)

        output.printed.takeLast(3) shouldBe listOf(
            "3개 일치 (1000원)- 2개",
            "4개 일치 (2000원)- 0개",
            "5개 일치 (3000원)- 1개",
        )
    }
})
