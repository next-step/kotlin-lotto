package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinnerTest: StringSpec({

    "입력 값을 리스트로 반환한다"{
        val winner = Winner("1,2,3,4")
        winner.getWinnerNumbers() shouldBe listOf(1,2,3,4)
    }

    "매칟되는 숫자의 갯수를 반환한다"{
        val winner = Winner((1..45).toList())
        val lotto = Lotto(1)
        val tickets = lotto.purchaseTicket()
        val matchingInfo = winner.checkNumberMatch(tickets)
        matchingInfo[Reward.`2000000000`] shouldBe 1
    }
})
