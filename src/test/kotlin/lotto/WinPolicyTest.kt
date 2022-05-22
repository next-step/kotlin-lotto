package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class WinPolicyTest : FreeSpec({

    "숫자 일치 개수와 당첨 금액을 받아서 정책을 생성한다" {
        val winPolicy = WinPolicy(3, Money(1000))

        winPolicy.matchCount shouldBe 3
        winPolicy.priceAmount shouldBe Money(1000)
    }
})
