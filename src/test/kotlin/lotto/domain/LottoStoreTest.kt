package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "0, 0",
            "999, 0",
            "1000, 1",
            "5000, 5",
        ]
    )
    fun `로또는 1000원당 한 장을 살 수 있다`(money: Int, lottoCount: Int) {
        val lottoGenerateStrategy = LottoGenerateStrategy { Lotto.of(listOf(1, 2, 3, 4, 5, 6)) }
        val lottoGenerator = LottoGenerator(lottoGenerateStrategy)
        val lottoStore = LottoStore(lottoGenerator)

        val lottos = lottoStore.buyLottos(money)

        assertThat(lottos.value.size).isEqualTo(lottoCount)
    }
}
