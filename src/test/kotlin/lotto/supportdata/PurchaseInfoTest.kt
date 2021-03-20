package lotto.supportdata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class PurchaseInfoTest {

    @Test
    @DisplayName("가격만 넣으면 자동으로 구매한 총 로또 티켓 장수를 알 수 있다.")
    fun getTicketNumber() {
        val purchaseInfo = PurchaseInfo(14000)
        assertThat(purchaseInfo.autoTicketNumber).isEqualTo(14)
    }

    @Test
    @DisplayName("수동으로 구매할 로또 티켓을 설정하고, 각각의 로또 티켓 장수를 알 수 있다.")
    fun getEachTicketNumber() {
        val purchaseInfo = PurchaseInfo(14000, listOf("1,2,3,4,5,6", "1,2,3,4,5,6"))
        assertThat(purchaseInfo.autoTicketNumber).isEqualTo(12)
        assertThat(purchaseInfo.manualTicketNumber).isEqualTo(2)
    }

    @Test
    @DisplayName("수동으로 구매할 로또 티켓 숫자를 입력을 설정할 수 있다.")
    fun getManualLottoTickets() {
        val purchaseInfo = PurchaseInfo(14000, listOf("1,2,3,4,5,6", "1,2,3,4,5,6"))
        assertThat(purchaseInfo.manualTicket.size).isEqualTo(2)
    }

    @Test
    @DisplayName("티켓 가격에 딱 맞지 않더라도, 구매한 로또 티켓 장수를 알 수 있다.")
    fun getMoney() {
        val purchaseInfo = PurchaseInfo(14500)
        assertThat(purchaseInfo.autoTicketNumber).isEqualTo(14)
    }
}
