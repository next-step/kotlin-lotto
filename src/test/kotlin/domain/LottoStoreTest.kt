package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoStoreTest {
    @Test
    fun `로또판매기는 로또 가격으로 생성된다`() {
        assertDoesNotThrow { LottoStore(price = Money(1000)) }
    }

    @Test
    fun `로또판매기의 로또 가격은 0원일 수 없다`() {
        assertThatIllegalArgumentException().isThrownBy { LottoStore(Money.ZERO) }
    }

    @Test
    fun `로또판매기에 돈을 주고 로또들을 살 수 있다`() {
        val store = LottoStore(Money(1000))
        assertDoesNotThrow {
            val lottos: List<Lotto> = store.buyLottos(Money(1000))
        }
    }

    @ParameterizedTest
    @CsvSource(
        "1000, 999, 0",
        "1000, 1001, 1",
        "1000, 10000, 10",
        "500, 999, 1",
        "500, 1001, 2",
        "500, 10000, 20"
    )
    fun `로또판매기에 준 돈으로 살 수 있는 최대한의 로또를 살 수 있다`(lottoPrice: Int, moneyToBuy: Int, lottoCount: Int) {
        val store = LottoStore(Money(lottoPrice))
        assertThat(store.buyLottos(Money(moneyToBuy))).hasSize(lottoCount)
    }
}
