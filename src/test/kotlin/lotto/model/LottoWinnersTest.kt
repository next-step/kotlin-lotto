package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.app.LottoApp

class LottoWinnersTest : StringSpec({

    "1등 당첨시의 수익률을 반환해야한다" {
        val winner1st = LottoWinners(totalGameCount = 1, countOf1st = 1)
        val actual = winner1st.earningInfo(LottoApp.pricePerGame())
        actual shouldBe Pair((2000000000.toDouble() / 1000), "이익")
    }

    "3등 당첨시의 수익률을 반환해야한다" {
        val winner3rd = LottoWinners(totalGameCount = 1, countOf3rd = 1)
        val actual = winner3rd.earningInfo(LottoApp.pricePerGame())
        actual shouldBe Pair((1500000.toDouble() / 1000), "이익")
    }

    "4등 당첨시의 수익률을 반환해야한다" {
        val winner4th = LottoWinners(totalGameCount = 1, countOf4th = 1)
        val actual = winner4th.earningInfo(LottoApp.pricePerGame())
        actual shouldBe Pair((50000.toDouble() / 1000), "이익")
    }

    "5등 당첨시의 수익률을 반환해야한다" {
        val winner5th = LottoWinners(totalGameCount = 1, countOf5th = 1)
        val actual = winner5th.earningInfo(LottoApp.pricePerGame())
        actual shouldBe Pair((5000.toDouble() / 1000), "이익")
    }

    "10장을 구매해서 5등에 한장 당첨된 상황의 수익률을 반환 해야 한다" {
        val half = LottoWinners(totalGameCount = 10, countOf5th = 1)
        val actual = half.earningInfo(LottoApp.pricePerGame())
        actual shouldBe Pair((5000.toDouble() / 10000), "손해")
    }

    "아무것도 당첨되지 않았을때의 수익률은 0을 반환해야 한다" {
        val boom = LottoWinners(totalGameCount = 20)
        val actual = boom.earningInfo(LottoApp.pricePerGame())
        actual shouldBe Pair(0.toDouble(), "손해")
    }
})
