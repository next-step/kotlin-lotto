package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({
    "로또 머신은 로또 숫자 6개가 담긴 로또 티켓을 생성해요" {
        val lottoMachine = LottoMachine()

        val lottoTicket = lottoMachine.generate()

        lottoTicket.numbers.size shouldBe 6
    }

    "로또 머신이 생성한 로또 티켓은 항상 오름차순으로 정렬되어요" {
        val lottoMachine = LottoMachine()

        val lottoTicket = lottoMachine.generate()

        val lottoNumbers = lottoTicket.numbers
        val sortedLottoNumbers = lottoNumbers.sortedBy { it.number }

        lottoTicket.numbers shouldBe sortedLottoNumbers
    }

    "로또 머신은 금액에 따른 로또 구메 개수를 반환해요" {
        val lottoMachine = LottoMachine()
        val ticketAmount = lottoMachine.getTicketAmount(14000)

        ticketAmount shouldBe 14
    }
})
