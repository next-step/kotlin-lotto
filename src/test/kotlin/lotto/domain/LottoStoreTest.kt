package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.24..
 */
class LottoStoreTest {
    @ParameterizedTest
    @ValueSource(ints = [3000])
    internal fun `구매금액에 맞게 로또를 구매한다`(source: Int) {
        assertThat(LottoStore().buyLotto(source).size).isEqualTo(3)
    }
}
