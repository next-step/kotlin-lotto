package lotto

import lotto.domain.LottoStore
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {
    @ValueSource(ints = [14000, 23000])
    @ParameterizedTest
    fun `로또가 하나당 1000원으로 맞게 계산되는지 테스트`(money: Int) {
        val lottoStore = LottoStore(money)

        val answer = lottoStore.lottoCount
        val expect = money / 1000

        assertThat(answer).isEqualTo(expect)
    }
}
