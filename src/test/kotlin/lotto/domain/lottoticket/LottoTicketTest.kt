package lotto.domain.lottoticket

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers

internal class LottoTicketTest : FreeSpec({

    "수동으로 생성된 티켓인지, 자동으로 생성된 티켓인지 구별할 수 있다." - {
        val lottoNumbers = LottoNumbers(setOf(1, 2, 3, 4, 5, 6))

        "자동 로또 티켓" {
            val auto = LottoTicket.auto(lottoNumbers)
            auto.isAuto shouldBe true
            auto.isManual shouldBe false
        }

        "수동 로또 티켓" {
            val auto = LottoTicket.manual(lottoNumbers)
            auto.isManual shouldBe true
            auto.isAuto shouldBe false
        }
    }
})
