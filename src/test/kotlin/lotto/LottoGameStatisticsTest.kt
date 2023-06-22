package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoGameStatisticsTest {
    @Test
    fun `LottoGameStatistics은 로또 게임 결과를 받으면 roi를 계산한다`() {
        val purchaseAmount = 10000
        val winningNumbers = WinningNumbers(LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.from(7))
        val lottoNumbers = LottoNumbers.from(listOf(1, 2, 3, 7, 8, 9))
        val lottoGame = LottoGame(winningNumbers)
        val result = lottoGame.calculate(lottoNumbers)

        val statistics = LottoGameStatistics(purchaseAmount, result)

        statistics.roi shouldBe "0.5"
    }
}