package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe

class LottoGameResultTest : StringSpec({
    "로또 구입 금액 대비 로또 당첨 금액 수익률을 계산해요." {
        val lottoStatistics = LottoStatistics(
            mapOf(WinningAmount.FOURTH_PLACE to 1)
        )
        val lottoGameResult = LottoGameResult(lottoStatistics)

        val percent = lottoGameResult.getRateOfReturn(1000)

        percent.shouldBe(5.0 plusOrMinus 0.1)
    }
})
