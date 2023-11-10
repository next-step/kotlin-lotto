package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.app.LottoApp
import lotto.view.incomeStatement

class LottoWinnersTest : StringSpec({

    "1등 당첨시의 수익률을 반환해야한다" {
        val winner1st = LottoWinners(totalGameCount = 1, Rank.FIRST to 1)
        val actual = winner1st.earningRate(LottoApp.pricePerGame())
        actual shouldBe (2000000000.toDouble() / 1000)
    }

    "3등 당첨시의 수익률을 반환해야한다" {
        val winner3rd = LottoWinners(totalGameCount = 1, Rank.THIRD to 1)
        val actual = winner3rd.earningRate(LottoApp.pricePerGame())
        actual shouldBe (1500000.toDouble() / 1000)
    }

    "4등 당첨시의 수익률을 반환해야한다" {
        val winner4th = LottoWinners(totalGameCount = 1, Rank.FOURTH to 1)
        val actual = winner4th.earningRate(LottoApp.pricePerGame())
        actual shouldBe (50000.toDouble() / 1000)
    }

    "5등 당첨시의 수익률을 반환해야한다" {
        val winner5th = LottoWinners(totalGameCount = 1, Rank.FIFTH to 1)
        val actual = winner5th.earningRate(LottoApp.pricePerGame())
        actual shouldBe (5000.toDouble() / 1000)
    }

    "10장을 구매해서 5등에 한장 당첨된 상황의 수익률을 반환 해야 한다" {
        val half = LottoWinners(totalGameCount = 10, Rank.FIFTH to 1)
        val actual = half.earningRate(LottoApp.pricePerGame())
        actual shouldBe (5000.toDouble() / 10000)
    }

    "아무것도 당첨되지 않았을때의 수익률은 0을 반환해야 한다" {
        val boom = LottoWinners(totalGameCount = 20)
        val actual = boom.earningRate(LottoApp.pricePerGame())
        actual shouldBe 0.toDouble()
    }

    "0일때는 손해로 출력 되어야 한다" {
        val actual = (0.00).toDouble().incomeStatement()
        actual shouldBe "손해"
    }

    "1일 미만인 경우 손해로 출력 되어야 한다" {
        val actual = (0.99).incomeStatement()
        actual shouldBe "손해"
    }

    "1 일때는 이익으로 출력 되어야 한다" {
        val actual = (1.00).toDouble().incomeStatement()
        actual shouldBe "이익"
    }
})
