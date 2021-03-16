package lotto.supportdata

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class PurchaseInfoTest {

    @Test
    @DisplayName("가격을 넣으면 구매한 로또 티켓 장수를 알 수 있다.")
    fun getTicketNumber() {
        val purchaseInfo = PurchaseInfo(14000)
        assertThat(purchaseInfo.ticketNumber).isEqualTo(14)
    }

    @Test
    @DisplayName("티켓 가격에 딱 맞지 않더라도, 구매한 로또 티켓 장수를 알 수 있다.")
    fun getMoney() {
        val purchaseInfo = PurchaseInfo(14500)
        assertThat(purchaseInfo.ticketNumber).isEqualTo(14)
    }
}
