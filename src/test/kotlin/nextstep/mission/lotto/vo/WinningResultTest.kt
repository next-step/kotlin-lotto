package nextstep.mission.lotto.vo

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningResultTest : StringSpec({

    "당첨 상금에 대한 로또 당첨 갯수를 반환한다. 당첨 갯수가 없을 경우 0으로 반환한다." {
        listOf(
            WinningPrize.FIRST to 1,
            WinningPrize.THIRD to 2,
            WinningPrize.FOURTH to 3,
            WinningPrize.FIFTH to 0,
        ).forEach { (winningPrize: WinningPrize, count: Int) ->
            val winningResult = WinningResult(
                mapOf(
                    WinningPrize.FIRST to 1,
                    WinningPrize.THIRD to 2,
                    WinningPrize.FOURTH to 3,
                )
            )
            winningResult.getCount(winningPrize) shouldBe count
        }
    }

    "당첨 결과값에 따라 구매 비용 대비 수익률을 계산한다." {
        val winningResult = WinningResult(mapOf(WinningPrize.FOURTH to 1))
        winningResult.rateOfReturn(10_000) shouldBe 5
    }
})
