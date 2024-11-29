package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoProfitRate
import lotto.domain.LottoResult
import lotto.fake.FakeLottoNumbersGenerator
import org.junit.jupiter.api.Test

class LottoProfitRateTest {
    @Test
    fun `로또 총 수익률을 구할 수 있다`() {
        val firstLottoNumberGenerator = FakeLottoNumbersGenerator(listOf(1, 2, 3, 4, 5, 6))
        val secondLottoNumberGenerator = FakeLottoNumbersGenerator(listOf(1, 2, 3, 14, 15, 16))
        val lottos = listOf(Lotto(firstLottoNumberGenerator), Lotto(secondLottoNumberGenerator))
        val winnerNumbers = listOf(1, 2, 14, 18, 20, 21)
        val lottoResult = LottoResult(lottos, winnerNumbers)
        val lottoProfitRate =
            LottoProfitRate(
                lottoResult = lottoResult,
                purchaseAmount = 2000,
            )

        lottoProfitRate.profitRate shouldBe 2.5f
    }
}
