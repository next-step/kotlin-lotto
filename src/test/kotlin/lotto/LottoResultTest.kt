package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoPrize
import lotto.domain.LottoResult
import lotto.fake.FakeLottoNumbersGenerator
import org.junit.jupiter.api.Test

class LottoResultTest {
    private val winnerNumbers = listOf(1, 2, 14, 18, 20, 21)
    private val firstLottoNumberGenerator = FakeLottoNumbersGenerator(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `당첨 번호와 3개가 일치하는 로또 번호의 당첨 등수 개수를 알 수 있다`() {
        val secondLottoNumberGenerator = FakeLottoNumbersGenerator(listOf(1, 2, 3, 14, 15, 16))
        val lottos = listOf(Lotto(firstLottoNumberGenerator), Lotto(secondLottoNumberGenerator))
        val lottoResult = LottoResult(lottos, winnerNumbers)
        lottoResult.prizeCounts[LottoPrize.FOURTH] shouldBe 1
    }

    @Test
    fun `당첨 번호와 4개가 일치하는 로또 번호의 당첨 등수 개수를 알 수 있다`() {
        val secondLottoNumberGenerator = FakeLottoNumbersGenerator(listOf(1, 2, 3, 14, 18, 16))
        val lottos = listOf(Lotto(firstLottoNumberGenerator), Lotto(secondLottoNumberGenerator))
        val lottoResult = LottoResult(lottos, winnerNumbers)
        lottoResult.prizeCounts[LottoPrize.THIRD] shouldBe 1
    }

    @Test
    fun `당첨 번호와 5개가 일치하는 로또 번호의 당첨 등수 개수를 알 수 있다`() {
        val secondLottoNumberGenerator = FakeLottoNumbersGenerator(listOf(1, 2, 14, 18, 20, 22))
        val lottos = listOf(Lotto(firstLottoNumberGenerator), Lotto(secondLottoNumberGenerator))
        val lottoResult = LottoResult(lottos, winnerNumbers)
        lottoResult.prizeCounts[LottoPrize.SECOND] shouldBe 1
    }

    @Test
    fun `당첨 번호와 6개가 일치하는 로또 번호의 당첨 등수 개수를 알 수 있다`() {
        val secondLottoNumberGenerator = FakeLottoNumbersGenerator(listOf(1, 2, 14, 18, 20, 21))
        val lottos = listOf(Lotto(firstLottoNumberGenerator), Lotto(secondLottoNumberGenerator))
        val lottoResult = LottoResult(lottos, winnerNumbers)
        lottoResult.prizeCounts[LottoPrize.FIRST] shouldBe 1
    }
}
