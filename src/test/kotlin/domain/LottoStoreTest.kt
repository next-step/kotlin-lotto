package domain

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
}
