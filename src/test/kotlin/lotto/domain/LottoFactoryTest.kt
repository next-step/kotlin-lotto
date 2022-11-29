package lotto.domain

import lotto.domain.LottoConstants.LOTTE_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1000, 3000, 10000])
    fun `주어진 금액만큼 로또 번호가 담긴 로또를 생성한다`(amount: Int) {
        val lottoCount: Int = amount / LOTTE_PRICE
        val lottos = LottoFactory.purchaseLotto(Cash(amount))
        assertThat(lottos.count).isEqualTo(lottoCount)
    }

    @ParameterizedTest
    @CsvSource("3000", "1000")
    fun `수동 로또를 생성하고 나머지 금액만큼 자동 로또를 생성한다`(amount: Int) {
        val lottoCount: Int = amount / LOTTE_PRICE
        val manualLottos = Lottos(listOf(Lotto()))
        val lottos = LottoFactory.purchaseLotto(Cash(amount), manualLottos)
        lottos.lottoList.containsAll(manualLottos.lottoList)
        assertAll(
            { assertThat(lottos.count).isEqualTo(lottoCount) },
            { assertThat(lottos.lottoList).containsAll(manualLottos.lottoList) }
        )
    }
}
