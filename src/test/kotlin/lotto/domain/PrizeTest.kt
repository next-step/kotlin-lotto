package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import lotto.common.value.Money.Companion.toMoney
import lotto.domain.enums.Prize

class PrizeTest : FreeSpec({
    "추첨번호가 일치한 값을 넣으면 상금액을 확인할 수 있다" {
        val prize = Prize.find(3, false)
        prize.amount shouldBe 5_000L.toMoney()
    }

    "보너스 여부를 포함해서 상금액을 확인할 수 있다" {
        val prize = Prize.find(5, true)
        prize.amount shouldBe 30_000_000L.toMoney()
    }

    "추첨번호가 일치하지 않으면 꽝이 나온다" {
        Prize.find(1, false) shouldBe Prize.BOOM
    }

    "꽝이 아닌지를 판별할 수 있다" {
        Prize.THIRD.isNotBoom().shouldBeTrue()
    }
})
