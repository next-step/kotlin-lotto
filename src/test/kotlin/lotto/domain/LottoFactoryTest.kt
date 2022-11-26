package lotto.domain

import lotto.domain.LottoConstants.LOTTE_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = [1000, 3000, 10000])
    fun `주어진 금액만큼 로또 번호가 담긴 리켓을 생성한다`(amount: Int) {
        val lottoCount: Int = amount / LOTTE_PRICE
        val lottos = LottoFactory.purchaseLotto(amount)
        assertThat(lottos.size).isEqualTo(lottoCount)
    }
}
