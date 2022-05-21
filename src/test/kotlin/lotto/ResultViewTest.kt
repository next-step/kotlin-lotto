package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ResultViewTest : DescribeSpec({
    val fourthPrizePrice = 5000

    describe("showAnalyzeResult") {
        it("통계 값을 사용자에게 출력한다.") {
            val stub = StubOutput()
            val resultView = ResultView(stub)

            resultView.showAnalyzeResult(
                LottoResultDto(
                lottoResult = mapOf(
                    "3" to listOf(fourthPrizePrice, 1),
                    "4" to listOf(fourthPrizePrice, 0),
                    "5" to listOf(fourthPrizePrice, 0),
                    "6" to listOf(fourthPrizePrice, 0)
                ),
                rateOfReturn = "0.35"
            ))

            stub.view shouldBe "총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
    }


    describe("showLottos") {
        it("구매한 로또를 사용자에 출력한다.") {
            val stub = StubOutput()
            val resultView = ResultView(stub)

            resultView.showLottos(listOf(listOf(1,2,3,4,5,6)))

            stub.view shouldBe "[1, 2, 3, 4, 5, 6]"
        }
    }
})

class StubOutput : Output {
    lateinit var view: String

    override fun print(message: String) {
        this.view = message
    }
}