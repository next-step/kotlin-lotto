package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoTest {

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
    }

    @Test
    internal fun `로또 한 장의 금액은 1000원 이다`() {
        LottoVendingMachine.buyLotto(1000).size shouldBe 1
        LottoVendingMachine.buyLotto(14000).size shouldBe 14
    }

    @Test
    internal fun `로또 번호가 실제로 일치하는지`() {
        val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(2, 4, 6, 8, 10, 12)

        lotto.countMatch(winningLotto) shouldBe 3
    }

    @Test
    internal fun `로또 번호는 6개 이다`() {
        val lottoNumbersSize = Lotto().lottoNumbers.size

        lottoNumbersSize shouldBe 6
    }

    @Test
    internal fun `로또 번호는 오름차순 이다`() {
        val lottoNumbers = Lotto().lottoNumbers

        lottoNumbers shouldBe lottoNumbers.sortedBy { it.number }
    }
}
