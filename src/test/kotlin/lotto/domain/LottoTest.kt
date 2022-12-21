package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({

    "구입비에 따른 티켓 발권" {
        val lotto = Lotto(10000)
        lotto.purchaseTicket().size shouldBe 10
    }

    "구입비가 없을 경우 티켓이 발권 안 됨" {
        val lotto = Lotto(900)
        lotto.getCount() shouldBe 0
    }
})
