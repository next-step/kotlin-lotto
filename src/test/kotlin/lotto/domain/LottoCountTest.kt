package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoCountTest {
    @DisplayName("LottoCount 끼리 - 연산을 한 경우 연산 결과의 LottoCount 반환")
    @Test
    fun minus() {
        val actual = LottoCount(5) - LottoCount(3)
        assertThat(actual).isEqualTo(LottoCount(2))
    }

    @DisplayName("LottoCount 수 만큼 LottoTicket 을 반환하는 로직 수행")
    @Test
    fun repeat() {
        val tickets = LottoCount(3).repeat { createLotto(1, 2, 3, 4, 5, 6) }
        assertThat(tickets.size).isEqualTo(3)
    }
}
