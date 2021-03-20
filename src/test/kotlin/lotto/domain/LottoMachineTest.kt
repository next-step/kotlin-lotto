package lotto.domain

import lotto.supportdata.PurchaseInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class LottoMachineTest {

    @Test
    @DisplayName("주어진 구매 정보만큼 랜덤하게 숫자를 생성한 로또 티켓을 만들 수 있다.")
    fun makeRandomLottoTickets() {
        val lottoTicket = LottoMachine(PurchaseInfo(14000)).makeAutoLottoTickets()
        assertThat(lottoTicket.size).isEqualTo(14)
    }
}
