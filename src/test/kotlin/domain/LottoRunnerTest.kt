package domain

import LotteryRunner
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import mock.MockInputReader
import view.InputView

class LottoRunnerTest : StringSpec({
    "클라이언트가 구입 금액을 정상적으로 입력한다." {
        val inputView = InputView(MockInputReader(listOf("14000", "1,2,3", "1")))

        val lotteryRunner = LotteryRunner(inputView)
        lotteryRunner.startLotto()
    }

    "클라이언트가 잘못된 구입 금액을 입력한다." {
        val inputView = InputView(MockInputReader(listOf("공짜로 해줘")))
        shouldThrow<IllegalArgumentException> {
            val lotteryRunner = LotteryRunner(inputView)
            lotteryRunner.startLotto()
        }.message shouldBe "구입 금액이 올바르지 않습니다 : 공짜로 해줘"
    }

    "클라이언트의 금액에 따라 로또 장수를 리턴한다" {
        val inputView = InputView(MockInputReader(listOf("14000", "1,2,3", "1")))

        val lotteryRunner = LotteryRunner(inputView)
        lotteryRunner.startLotto()
        lotteryRunner.lotteries.size shouldBe 14
    }
})
