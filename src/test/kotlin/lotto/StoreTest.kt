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
        buyer = Buyer(2_000).apply {
            markLotto(Lotto(setOf(1, 2, 3, 4, 5, 6)))
            markLotto(Lotto(setOf(1, 2, 3, 4, 5, 45)))
        }
        store = Store(buyer)
    }

    @Test
    fun 꽝() {
        val winnerHistory = store.drawLottoNumber(Lotto(setOf(7, 8, 9, 10, 11, 12)))

        assertThat(winnerHistory.contains(Prize.NOTHING)).isTrue()
    }

    @Test
    fun `5천원 당첨`() {
        val winnerHistory = store.drawLottoNumber(Lotto(setOf(1, 2, 3, 14, 15, 16)))

        assertThat(winnerHistory.contains(Prize.FOURTH)).isTrue()
    }

    @Test
    fun `5만원 당첨`() {
        val winnerHistory = store.drawLottoNumber(Lotto(setOf(1, 2, 3, 4, 15, 16)))

        assertThat(winnerHistory.contains(Prize.THIRD)).isTrue()
    }

    @Test
    fun `150만원 당첨`() {
        val winnerHistory = store.drawLottoNumber(Lotto(setOf(1, 2, 3, 4, 5, 16)))

        assertThat(winnerHistory.contains(Prize.SECOND)).isTrue()
    }

    @Test
    fun `3천만원 당첨`() {
        val winnerHistory = store.drawLottoNumber(Lotto(setOf(1, 2, 3, 4, 5, 16)), 6)

        assertThat(winnerHistory.contains(Prize.BETWEEN_FIRST_AND_SECOND)).isTrue()
    }

    @Test
    fun `20억 당첨`() {
        val winnerHistory = store.drawLottoNumber(Lotto(setOf(1, 2, 3, 4, 5, 6)))

        assertThat(winnerHistory.contains(Prize.FIRST)).isTrue()
    }

    @Test
    fun `수익률 조회`() {
        val winnerHistory = store.drawLottoNumber(Lotto(setOf(1, 2, 3, 14, 15, 16)))

        assertThat(store.getRateOfReturn(14_000, winnerHistory)).isEqualTo(0.71)
    }

    @Test
    fun `150만원과 3천만원 둘다 당첨될 경우`() {
        val winnerHistory = store.drawLottoNumber(Lotto(setOf(1, 2, 3, 4, 5, 16)), 45)

        assertThat(winnerHistory.contains(Prize.SECOND) && winnerHistory.contains(Prize.BETWEEN_FIRST_AND_SECOND)).isTrue()
    }
}
