package lotto

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import lotto.domain.Lottos
import org.junit.jupiter.api.Test

class LottosTest {

    @Test
    internal fun `로또 구매 금액은 0이거나 null이 아니어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            Lottos.buyLotto(0)
        }
        shouldThrow<IllegalArgumentException> {
            Lottos.buyLotto(null)
        }
    }

    @Test
    internal fun `로또 구매 금액은 1000이상이어야 한다`() {
        shouldThrow<IllegalArgumentException> {
            Lottos.buyLotto(999)
        }
        shouldNotThrow<IllegalArgumentException> {
            Lottos.buyLotto(1000)
        }
    }

    @Test
    internal fun `로또 한 장의 금액은 1000원 이다`() {
        Lottos.buyLotto(1000).lottos.size shouldBe 1
        Lottos.buyLotto(14000).lottos.size shouldBe 14
    }
}
