package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.common.Money
import lotto.domain.enums.Prize

class PrizeTest : FreeSpec({
    "추첨번호가 일치한 값을 넣으면 상금액을 확인할 수 있다" {
        val prize = Prize.find(3)
        prize.amount shouldBe Money.from(50_000)
    }

    "추첨번호가 일치하지 않으면 꽝이 나온다" {
        Prize.find(1) shouldBe Prize.BOOM
    }
})