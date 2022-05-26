package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatisticsTest {

    @Test
    fun `일치하는 숫자가 3개인 로또가 한개인 경우 통계데이터 확인`() {
        assertThat(
            Statistics().apply {
                this.run(
                    winningPrizes = WinningPrizes(prizes = listOf(LottoResult.Prize.THIRD)),
                    purchaseMoney = PurchaseMoney(14000)
                )
            }.earnings
        ).isEqualTo(0.35)
    }

    @Test
    fun `일치하는 숫자가 6개인 로또가 한개인 경우 통계데이터 확인`() {
        assertThat(
            Statistics().apply {
                this.run(
                    winningPrizes = WinningPrizes(prizes = listOf(LottoResult.Prize.SIXTH)), purchaseMoney = PurchaseMoney(1000)
                )
            }.earnings
        ).isEqualTo(2000000.0)
    }
}
