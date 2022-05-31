package lotto.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.NormalLottery
import lotto.vo.LotteryNumber
import lotto.vo.LottoSet

internal class LottoResultViewTest : BehaviorSpec({

    given("주어진 로또 세트와, 지난주 로또 번호를 입력으로") {
        val normalLotterySet = LottoSet(
            listOf(
                NormalLottery(listOf(1, 2, 3, 4, 5, 6).map(LotteryNumber::of)),
                NormalLottery(listOf(1, 2, 3, 4, 5, 7).map(LotteryNumber::of)),
            )
        )
        val lastWeekNormalLottery = NormalLottery(listOf(1, 2, 3, 4, 5, 6).map(LotteryNumber::of))
        val stubIOSystem = StubIOSystem("")
        val lottoResultView = LottoResultView(stubIOSystem)

        `when`("결과를 출력 시") {
            lottoResultView.printResult(normalLotterySet, lastWeekNormalLottery)

            then("각 등수의 당첨수와 이익률을 출력한다.") {
                val expected = """
                |당첨 통계
                |-------
                |3개 일치(5000원)-0개
                |4개 일치(50000원)-0개
                |5개 일치(1500000원)-1개
                |6개 일치(2000000000원)-1개
                |총 수익률은 1000750.0입니다.
                """.trimMargin()
                stubIOSystem.screenBuffer.joinToString("") shouldBe expected
            }
        }
    }
})
