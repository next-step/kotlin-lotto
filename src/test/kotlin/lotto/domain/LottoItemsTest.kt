package lotto.domain

import lotto.domain.value.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoItemsTest {
    private val lottoItems = LottoItems(5)

    @Test
    fun getLottoItems() {
        assertThat(lottoItems.getLottoItems().size).isEqualTo(5)
    }

    @Test
    fun getWinLottos() {
        val winningNumbers = List(6) { i -> LottoNumber(i + 1) }
        val winnintCount = lottoItems.getWinLottos(winningNumbers)
        assertThat(winnintCount).isEqualTo(3)
    }
}
