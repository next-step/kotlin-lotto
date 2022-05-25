package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoResultDto
import lotto.domain.Rank
import lotto.view.Output
import lotto.view.ResultView

class ResultViewTest : DescribeSpec({
    describe("showAnalyzeResult") {
        it("통계 값을 사용자에게 출력한다.") {
            val stub = StubOutput()
            val resultView = ResultView(stub)

            resultView.showAnalyzeResult(LottoResultDto(1, 0, 0, 0, "0.35"))

            stub.outputs[0] shouldBe "3개 일치 (${Rank.FOURTH.winningMoney}원)- 0개"
            stub.outputs[1] shouldBe "4개 일치 (${Rank.THIRD.winningMoney}원)- 0개"
            stub.outputs[2] shouldBe "5개 일치 (${Rank.SECOND.winningMoney}원)- 0개"
            stub.outputs[3] shouldBe "6개 일치 (${Rank.FIRST.winningMoney}원)- 1개"
            stub.outputs[4] shouldBe "총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"
        }
    }

    describe("showLottos") {
        it("구매한 로또를 사용자에 출력한다.") {
            val stub = StubOutput()
            val resultView = ResultView(stub)

            resultView.showLottos(listOf(listOf(1, 2, 3, 4, 5, 6)))

            stub.outputs[0] shouldBe "1개를 구입했습니다."
            stub.outputs[1] shouldBe "[1, 2, 3, 4, 5, 6]"
        }
    }
})

class StubOutput : Output {
    var outputs: MutableList<String> = mutableListOf()

    override fun print(message: String) {
        this.outputs.add(message)
    }
}
