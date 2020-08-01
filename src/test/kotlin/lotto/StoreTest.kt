package lotto

import lotto.model.Buyer
import lotto.model.Prize
import lotto.model.Store
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class StoreTest {
    @Test
    fun `5천원 당첨`() {
        val buyer = Buyer().apply { markLotto(listOf(1, 2, 3, 7, 8, 9)) }
        val store = Store(buyer)

        val winnerHistory = store.confirmLottoWining(listOf(1, 2, 3, 4, 5, 6))

        Assertions.assertThat(winnerHistory.contains(Prize.FORTH)).isTrue()
    }

    @Test
    fun `5만원 당첨`() {
        val buyer = Buyer().apply { markLotto(listOf(1, 2, 3, 4, 8, 9)) }
        val store = Store(buyer)

        val winnerHistory = store.confirmLottoWining(listOf(1, 2, 3, 4, 5, 6))

        Assertions.assertThat(winnerHistory.contains(Prize.THIRD)).isTrue()
    }

    @Test
    fun `150만원 당첨`() {
        val buyer = Buyer().apply { markLotto(listOf(1, 2, 3, 4, 5, 9)) }
        val store = Store(buyer)

        val winnerHistory = store.confirmLottoWining(listOf(1, 2, 3, 4, 5, 6))

        Assertions.assertThat(winnerHistory.contains(Prize.SECOND)).isTrue()
    }

    @Test
    fun `20억 당첨`() {
        val buyer = Buyer().apply { markLotto(listOf(1, 2, 3, 4, 5, 6)) }
        val store = Store(buyer)

        val winnerHistory = store.confirmLottoWining(listOf(1, 2, 3, 4, 5, 6))

        Assertions.assertThat(winnerHistory.contains(Prize.FIRST)).isTrue()
    }
}
