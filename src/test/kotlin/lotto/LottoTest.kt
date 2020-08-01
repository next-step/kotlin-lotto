package lotto

import lotto.model.Buyer
import lotto.model.Lotto
import lotto.model.Prize
import lotto.model.Store
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 형식 체크`() {
        val lotto = Lotto().apply { generate(listOf(1, 2, 3, 4, 5, 6)) }
        assertThat(lotto.numbers.size).isEqualTo(6)
    }

    @Test
    fun `로또 구매`() {
        val buyer = Buyer()

        buyer.buyAll(14_000)

        assertThat(buyer.purchasedLottos.size).isEqualTo(14)
    }

    @Test
    fun `로또 구매 금액이 부족한 경우`() {
        val buyer = Buyer()

        assertThatIllegalArgumentException().isThrownBy {
            buyer.buyAll(900)
        }
    }

    @Test
    fun `5천원 당첨`() {
        val buyer = Buyer().apply { markLotto(listOf(1, 2, 3, 7, 8, 9)) }
        val store = Store(buyer)

        val winnerHistory = store.confirmLottoWining(listOf(1, 2, 3, 4, 5, 6))

        assertThat(winnerHistory.contains(Prize.NO_FOUR)).isTrue()
    }
}
