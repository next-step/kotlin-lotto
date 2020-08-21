package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoProgramTest {
    @DisplayName("구입한 금액 만큼의 로또 장수를 반환한다.")
    @Test
    fun `when input amountOfMoney then return amountOfLotto`() {
        assertThat(LottoProgram.getAmountOfLotto(3000)).isEqualTo(3)
    }

    @DisplayName("로또의 수익률을 계산한다.")
    @Test
    fun calculateRateOfReturn() {
        val ranks = listOf(Rank.FIFTH)
        val amountOfMoney = 14000
        assertThat(LottoProgram.calculateRateOfReturn(ranks, amountOfMoney)).isEqualTo(0.36)
    }
}
