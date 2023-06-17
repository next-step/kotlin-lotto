package domain

import LotteryRunner
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoRunnerTest : StringSpec({
    "클라이언트가 구입 금액을 정상적으로 입력한다." {
        LotteryRunner.startLotto(14000, setOf(1, 2, 3), 1)
    }

    "클라이언트의 금액에 따라 로또 장수를 리턴한다" {
        LotteryRunner.startLotto(14000, setOf(1, 2, 3), 1)
        LotteryRunner.lotteries.size shouldBe 14
    }
})
