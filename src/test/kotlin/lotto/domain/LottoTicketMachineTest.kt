package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import lotto.domain.lottoticket.LottoNumber

internal class LottoTicketMachineTest : FreeSpec({

    "주어진 수동숫자로 로또티켓를 발급한다." {
        // given
        val lottoTicketMachine = LottoTicketMachine()

        // when
        val lottoTicket = lottoTicketMachine.createManualTicket(listOf(1, 2, 3, 4, 5, 6))

        // then
        lottoTicket.lottoNumbers.values shouldContainExactly setOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6),
        )
    }

    "주어진 개수만큼 자동 로또티켓를 발급한다." {
        // given
        val lottoTicketMachine = LottoTicketMachine()

        // when
        val lottoTickets = lottoTicketMachine.createAutoTickets(5)

        // then
        lottoTickets.count shouldBe 5
    }
})
