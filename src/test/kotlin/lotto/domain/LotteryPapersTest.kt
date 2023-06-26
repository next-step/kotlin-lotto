package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LotteryPapersTest {

    private lateinit var lotteryPapers: LotteryPapers

    @BeforeEach
    fun setUp() {
        lotteryPapers = LotteryPapers(RandomLottoNumberGenerationStrategy())
    }

    @Test
    fun `1부터 45까지 숫자중 6개의 숫자를 무작위로 로또 번호를 생성한다`() {
        lotteryPapers.generateRandomLottoNumber()
        val purcahsedLotteryPapers = lotteryPapers.getPurchasedLotteryPapers()
        val lotteryPaperList = purcahsedLotteryPapers.lotteryPaperList
        val lottoNumber = lotteryPaperList[0].getLottoNumber()
        Assertions.assertThat(lottoNumber).hasSize(6).allMatch { it in 1..45 }
    }

    @Test
    fun `생성된 로또 번호는 중복이 없다`() {
        lotteryPapers.generateRandomLottoNumber()
        val purcahsedLotteryPapers = lotteryPapers.getPurchasedLotteryPapers()
        val lotteryPaperList = purcahsedLotteryPapers.lotteryPaperList
        val lottoNumber = lotteryPaperList[0].getLottoNumber()
        Assertions.assertThat(lottoNumber.size).isEqualTo(lottoNumber.toSet().size)
    }

    @Test
    fun `로또 용지에 중복이 생기면 IllegalArgumentException을 throw한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotteryPaperList = listOf(
            LotteryPaper(lottoNumbers),
            LotteryPaper(lottoNumbers)
        )

        assertThrows<IllegalArgumentException> { LotteryPapers.validateDuplicateLotteryPaper(lotteryPaperList) }
    }
}
