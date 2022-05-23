package lotto.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMatchResult
import lotto.domain.Money
import lotto.domain.Profit

internal class ProfitViewTest : StringSpec({

    "수익률를 1.0 이상이면 수익률 정보만 출력한다" {
        val output = StubOutput()
        val view = ProfitView(output)
        val profit = Profit(Money(100), listOf(LottoMatchResult(1, Money(100), 1)))

        view.print(profit)

        output.printed.first() shouldBe "총 수익률은 1.00입니다."
    }

    "수익률이 1.0 보다 작으면 추가 참고문구도 같이 출력한다" {
        val output = StubOutput()
        val view = ProfitView(output)
        val profit = Profit(Money(100), listOf(LottoMatchResult(1, Money(80), 1)))

        view.print(profit)

        output.printed.first() shouldBe "총 수익률은 0.80입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
    }
})
