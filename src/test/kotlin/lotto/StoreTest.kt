package lotto

import lotto.model.Buyer
import lotto.model.Lotto
import lotto.model.Prize
import lotto.model.Store
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class StoreTest {

    private lateinit var buyer: Buyer
    private lateinit var store: Store

    @BeforeEach
    fun setup() {
        buyer = Buyer()
        store = Store(buyer)
    }

    @Test
    fun `5천원 당첨`() {
        buyer.markLotto(Lotto(listOf(1, 2, 3, 7, 8, 9)))

        val winnerHistory = store.drawLottoNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)))

        assertThat(winnerHistory.contains(Prize.FOURTH)).isTrue()
    }

    @Test
    fun `5만원 당첨`() {
        buyer.markLotto(Lotto(listOf(1, 2, 3, 4, 8, 9)))

        val winnerHistory = store.drawLottoNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)))

        assertThat(winnerHistory.contains(Prize.THIRD)).isTrue()
    }

    @Test
    fun `150만원 당첨`() {
        buyer.markLotto(Lotto(listOf(1, 2, 3, 4, 5, 9)))

        val winnerHistory = store.drawLottoNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)))

        assertThat(winnerHistory.contains(Prize.SECOND)).isTrue()
    }

    @Test
    fun `20억 당첨`() {
        buyer.markLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)))

        val winnerHistory = store.drawLottoNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)))

        assertThat(winnerHistory.contains(Prize.FIRST)).isTrue()
    }

    @Test
    fun `수익률 조회`() {
        buyer.markLotto(Lotto(listOf(1, 2, 3, 7, 8, 9)))

        val winnerHistory = store.drawLottoNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)))

        assertThat(store.getRateOfReturn(14_000, winnerHistory)).isEqualTo(0.35)
    }
}
