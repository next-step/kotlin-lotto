package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ResultViewTest : DescribeSpec({
    val fourthPrizePrice = 5000

    describe("show") {
        it("통계 값을 사용자에게 출력한다.") {
            val stub = StubOutput()
            val resultView = ResultView(stub)

            resultView.showAnalyzeResult(mapOf<String, Any>("bf" to "0"))

            stub.view shouldBe "총 수익률은 0입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
    }

    describe("parseFor") {
        context("당첨 결과에 대한 데이터일 때") {
            it("화면에 출력할 통계 자료로 변환한다.") {
                val resultView = ResultView(StubOutput())

                val result = resultView.parseFor("3", listOf(fourthPrizePrice, 0))

                result shouldBe "3개 일치 (5000원)- 0개"
            }
        }

        context("총 수익률에 대한 데이터일 때") {
            it("화면에 출력할 통계 자료로 변환한다.") {
                val resultView = ResultView(StubOutput())

                val result = resultView.parseFor("bf", "0.35")

                result shouldBe "총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
            }

            context("총 수익률이 1 이상이라면") {
                it("화면에 출력할 통계 자료로 변환한다.") {
                    val resultView = ResultView(StubOutput())

                    val result = resultView.parseFor("bf", "1.5")

                    result shouldBe "총 수익률은 1.5입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"
                }
            }
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