package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({
    "로또 머신은 로또 로또 티켓 금액 만큼 로또를 구매해요" {
        val lottoMachine = LottoMachine()

        val lottoTickets = lottoMachine.ticketing(1000)

        lottoTickets.size shouldBe 1
    }

    "로또 머신은 로또 숫자 6개가 담긴 로또 티켓을 생성해요" {
        val lottoMachine = LottoMachine()

        val lottoTickets = lottoMachine.ticketing(1000)

        lottoTickets.first().numbers.size shouldBe 6
    }

    "로또 머신이 생성한 로또 티켓은 항상 오름차순으로 정렬되어요" {
        val lottoMachine = LottoMachine()

        val lottoTickets = lottoMachine.ticketing(1000)

        val lottoNumbers = lottoTickets.first().numbers
        val sortedLottoNumbers = lottoNumbers.sortedBy { it.number }

        lottoNumbers shouldBe sortedLottoNumbers
    }
})
