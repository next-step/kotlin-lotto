package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMachine
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

class LottoMachineTest : StringSpec({
    "1~45 사이의 랜덤 숫자 6개를 반환한다." {
        //given
        val lottoMachine = LottoMachine()
        //when
        val lottoNumbers = lottoMachine.autoPurchase(1).lottoTickets[0]
        //then
        lottoNumbers.lottoNumbers.size shouldBe 6
        lottoNumbers.lottoNumbers.forAll { it.value shouldBeInRange 1..45 }
    }

    "manual로 로또 티켓을 생성한다." {
        //given
        val lottoMachine = LottoMachine()
        //when
        val lottoTicketBulk = lottoMachine.manualPurchase(listOf(setOf(1, 2, 3, 4, 5, 6)))
        //then
        lottoTicketBulk.size() shouldBe 1
        lottoTicketBulk.lottoTickets[0].lottoNumbers shouldContainExactly (1..6).map { LottoNumber(it) }
    }
})
