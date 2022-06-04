package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.24..
 */
class LottoStoreTest {
    @ParameterizedTest
    @ValueSource(ints = [3000])
    internal fun `구매금액에 맞게 로또를 구매한다`(source: Int) {
        assertThat(LottoStore(source).buyAutoLotto().getSize()).isEqualTo(3)
    }

    @Test
    internal fun `수동으로 구매할 로또 수는 구매금액을 넘을 경우 IllegalArgumentException을 던진다`() {
        assertThrows<IllegalArgumentException> {
            LottoStore(0).buyManualLotto({ 3 }, { listOf() })
        }
    }
}
