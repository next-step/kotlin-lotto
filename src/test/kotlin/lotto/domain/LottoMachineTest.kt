package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {
    @Test
    fun `로또 기계에 보너스 값을 전달한다`() {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val lottoTickets = LottoMachine().purchase(
            money = Money(1000),
            randomNumberFunc = { lottoNumbers }
        )

        assertThat(lottoTickets.lottoTickets.size).isEqualTo(1)
    }

    @Test
    fun `로또 Prize을 확인하기 위하여 당첨 번호 일치 여부를 전달한다`() {
        val lottoTickets = LottoMachine().purchase(
            money = Money(1000),
            randomNumberFunc = { (1..6).map { LottoNumber(it) } }
        )

        assertThat(lottoTickets.lottoTickets.size).isEqualTo(1)
    }

    @Test
    fun `보너스 번호는 없으며 당첨번호 3개로 구성된 내용을 확인한다`() {
        val lottoTickets = LottoMachine().purchase(
            money = Money(1000),
            randomNumberFunc = { (1..6).map { LottoNumber(it) } }
        )

        assertThat(lottoTickets.lottoTickets.size).isEqualTo(1)
    }

    @Test
    fun `로또 기계는 티켓 구매를 위해 금액, 수동 번호, 랜덤 숫자 생성 로직을 전달 받는다`() {
        LottoMachine().purchase(
            money = Money(1),
            manualTicket = LottoTickets(),
            randomNumberFunc = { (1..6).map { LottoNumber(it) } }
        )
    }

    @Test
    fun `로또 기계는 티켓 구매시 수동 티켓을 제외한 차액만큼 자동 티켓을 생성한다`() {
        val purchase = LottoMachine().purchase(
            money = Money(3000),
            manualTickets = LottoTickets(listOf(LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }))),
            randomNumberFunc = { (1..6).map { LottoNumber(it) } }
        )

        assertThat(purchase.manualTickets.lottoTickets.size).isEqualTo(1)
        assertThat(purchase.autoTickets.lottoTickets.size).isEqualTo(2)
    }
}
