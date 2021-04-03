package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoStoreTest {
    @DisplayName("로또 구매 금액을 입력한 경우 로또 생성")
    @Test
    fun purchase() {
        val lottoTickets = LottoStore.purchase("2000", ONE_TO_SIX)
        assertThat(lottoTickets.tickets.size).isEqualTo(2)
    }
}
