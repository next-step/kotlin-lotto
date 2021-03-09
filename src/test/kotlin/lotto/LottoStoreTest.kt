package lotto

import lotto.LottoStore.Companion.LOTTO_COST
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoStoreTest {

    private val lottoStore = LottoStore()

    @ParameterizedTest
    @ValueSource(ints = [1000, 10000, 14000])
    fun `금액넣었을때 금액에 맞는 로또가 생성되는지 확인`(money: Int) {
        val lottos = lottoStore.purchaseAuto(money)
        assertThat(lottos.toList().size).isEqualTo(money / LOTTO_COST)
    }
}
