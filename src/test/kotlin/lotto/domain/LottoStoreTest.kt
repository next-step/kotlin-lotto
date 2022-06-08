package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.24..
 */
class LottoStoreTest {
    @ParameterizedTest
    @ValueSource(ints = [3000])
    internal fun `구매금액에 맞게 로또를 구매한다`(source: Int) {
        assertThat(LottoStore(Money(source)).buyAutoLotto().getSize()).isEqualTo(3)
    }

    @Test
    internal fun `수동으로 구매할 로또 수는 구매금액을 넘을 경우 IllegalArgumentException을 던진다`() {
        assertThrows<IllegalArgumentException> {
            LottoStore(Money(0)).buyManualLotto({ 3 }, { listOf() })
        }
    }

    @ParameterizedTest
    @CsvSource("1, '1, 2, 3, 4, 5, 6'", "2, '1, 2, 3, 4, 5, 6'")
    internal fun `수동으로 구매시 구매할 로또 수 만큼 구매한다`(count: Int, ticketNumber: String) {
        assertThat(
            LottoStore(Money(count * 1000)).buyManualLotto(
                { count },
                { List(count) { ticketNumber } }
            ).tickets.size
        ).isEqualTo(count)
    }
}
