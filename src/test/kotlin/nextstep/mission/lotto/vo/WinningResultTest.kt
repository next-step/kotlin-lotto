package nextstep.mission.lotto.vo

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import nextstep.mission.lotto.WinningPrize

class WinningResultTest : StringSpec({

    "당첨 상금에 대한 로또 당첨 갯수를 반환한다. 당첨 갯수가 없을 경우 0으로 반환한다." {
        listOf(
            WinningPrize.FIRST to 1,
            WinningPrize.SECOND to 2,
            WinningPrize.THIRD to 3,
            WinningPrize.FOURTH to 0,
        ).forEach { (winningPrize: WinningPrize, count: Int) ->
            val winningResult = WinningResult(
                mapOf(
                    WinningPrize.FIRST to 1,
                    WinningPrize.SECOND to 2,
                    WinningPrize.THIRD to 3,
                )
            )
            winningResult.getCount(winningPrize) shouldBe count
        }
    }
})
