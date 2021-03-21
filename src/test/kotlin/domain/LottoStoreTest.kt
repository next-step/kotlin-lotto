package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test

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

    @Test
    fun `로또판매기에 준 돈으로 살 수 있는 최대한의 로또를 살 수 있다`() {
        var store = LottoStore(Money(1000))
        assertThat(store.buyLottos(Money(999))).hasSize(0)
        assertThat(store.buyLottos(Money(1001))).hasSize(1)
        assertThat(store.buyLottos(Money(10000))).hasSize(10)

        store = LottoStore(Money(500))
        assertThat(store.buyLottos(Money(999))).hasSize(1)
        assertThat(store.buyLottos(Money(1001))).hasSize(2)
        assertThat(store.buyLottos(Money(10000))).hasSize(20)
    }
}
