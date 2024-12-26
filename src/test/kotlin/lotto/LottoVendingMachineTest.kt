package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoVendingMachineTest {

    @Test
    internal fun `로또 구매 금액은 0이거나 null이 아니어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoVendingMachine.buyLotto(0)
        }
        shouldThrow<IllegalArgumentException> {
            LottoVendingMachine.buyLotto(null)
        }
    }

    @Test
    internal fun `로또 구매 금액은 1000이상이어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            LottoVendingMachine.buyLotto(999)
        }
        shouldNotThrow<IllegalArgumentException> {
            LottoVendingMachine.buyLotto(1000)
        }
    }

    @Test
    internal fun `로또 한 장의 금액은 1000원 이다`() {
        LottoVendingMachine.buyLotto(1000).size shouldBe 1
        LottoVendingMachine.buyLotto(14000).size shouldBe 14
    }
}
