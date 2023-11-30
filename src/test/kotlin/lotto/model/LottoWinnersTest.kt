package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoWinnersTest : StringSpec({

    val priceOfGame = 1000
    "1등 당첨시의 수익률을 반환해야한다" {
        val winner1st = LottoWinners(totalGameCount = 1, Rank.FIRST to 1)
        val actual = winner1st.earningRate(priceOfGame)
        actual shouldBe (2000000000.toDouble() / 1000)
    }

    "3등 당첨시의 수익률을 반환해야한다" {
        val winner3rd = LottoWinners(totalGameCount = 1, Rank.THIRD to 1)
        val actual = winner3rd.earningRate(priceOfGame)
        actual shouldBe (1500000.toDouble() / 1000)
    }

    "4등 당첨시의 수익률을 반환해야한다" {
        val winner4th = LottoWinners(totalGameCount = 1, Rank.FOURTH to 1)
        val actual = winner4th.earningRate(priceOfGame)
        actual shouldBe (50000.toDouble() / 1000)
    }

    "5등 당첨시의 수익률을 반환해야한다" {
        val winner5th = LottoWinners(totalGameCount = 1, Rank.FIFTH to 1)
        val actual = winner5th.earningRate(priceOfGame)
        actual shouldBe (5000.toDouble() / 1000)
    }

    "10장을 구매해서 5등에 한장 당첨된 상황의 수익률을 반환 해야 한다" {
        val half = LottoWinners(totalGameCount = 10, Rank.FIFTH to 1)
        val actual = half.earningRate(priceOfGame)
        actual shouldBe (5000.toDouble() / 10000)
    }

    "아무것도 당첨되지 않았을때의 수익률은 0을 반환해야 한다" {
        val boom = LottoWinners(totalGameCount = 20)
        val actual = boom.earningRate(priceOfGame)
        actual shouldBe 0.toDouble()
    }
})
