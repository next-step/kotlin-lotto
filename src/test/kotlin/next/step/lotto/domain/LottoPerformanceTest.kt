package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoPerformanceTest : DescribeSpec({

    describe("수익률 계산") {
        context("로또 구매 금액과, 총 당첨 금액을 넣으면") {
            it("수익률을 소수점 둘째자리까지 제공") {
                LottoPerformance.analyze(1000, 150) shouldBe "0.15"
            }
        }
    }
})
