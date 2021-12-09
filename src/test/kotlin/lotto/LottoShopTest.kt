package lotto

import lotto.domain.LottoShop
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoShopTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "20", "38", "111"])
    fun `구매한 로또 개수만큼 발권되는지 확인한`(ticketingCount: Int) {
        assertThat(LottoShop.createLottoTicket(ticketingCount).size).isEqualTo(ticketingCount)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "15"])
    fun `발권된 로또가 로또 범위(1~45)에 존재하는지 확인한다`(ticketingCount: Int) {
        LottoShop.createLottoTicket(ticketingCount).forEach { lotto ->
            lotto
                .getLottoNumber()
                .forEach { assertThat(it.number).isBetween(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER) }
        }
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
    }
}
