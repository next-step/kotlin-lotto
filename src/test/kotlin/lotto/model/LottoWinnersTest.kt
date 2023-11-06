package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.app.LottoApp

class LottoWinnersTest : StringSpec({

    "1등 당첨시의 수익률을 반환해야한다" {
        val winner1st = LottoWinners(totalGameCount = 1, countOf1st = 1)
        val actualEarningRate = winner1st.earningRate(LottoApp.pricePerGame())
        actualEarningRate shouldBe (2000000000.toDouble() / 1000)
    }

    "3등 당첨시의 수익률을 반환해야한다" {
        val winner3rd = LottoWinners(totalGameCount = 1, countOf3rd = 1)
        val actualEarningRate = winner3rd.earningRate(LottoApp.pricePerGame())
        actualEarningRate shouldBe (1500000.toDouble() / 1000)
    }

    "4등 당첨시의 수익률을 반환해야한다" {
        val winner4th = LottoWinners(totalGameCount = 1, countOf4th = 1)
        val actualEarningRate = winner4th.earningRate(LottoApp.pricePerGame())
        actualEarningRate shouldBe (50000.toDouble() / 1000)
    }

    "5등 당첨시의 수익률을 반환해야한다" {
        val winner5th = LottoWinners(totalGameCount = 1, countOf5th = 1)
        val actualEarningRate = winner5th.earningRate(LottoApp.pricePerGame())
        actualEarningRate shouldBe (2000000000.toDouble() / 1000)
    }

    "10장을 구매해서 5등에 한장 당첨된 상황의 수익률을 반환 해야 한다" {
        val half = LottoWinners(totalGameCount = 10, countOf5th = 1)
        val actualEarningRate = half.earningRate(LottoApp.pricePerGame())
        actualEarningRate shouldBe (5000.toDouble() / 10000)
    }

    "아무것도 당첨되지 않았을때의 수익률은 0을 반환해야 한다" {
        val boom = LottoWinners(totalGameCount = 20)
        val actualEarningRate = boom.earningRate(LottoApp.pricePerGame())
        actualEarningRate shouldBe 0.toDouble()
    }
})
