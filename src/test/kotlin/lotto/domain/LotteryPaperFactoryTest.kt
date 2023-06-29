package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LotteryPaperFactoryTest {

    private lateinit var lotteryPaperFactory: LotteryPaperFactory

    @BeforeEach
    fun setUp() {
        lotteryPaperFactory = LotteryPaperFactory(RandomLottoNumberGenerationStrategy())
    }

    @Test
    fun `1부터 45까지 숫자중 6개의 숫자를 선택해서 로또 번호를 생성한다`() {

        val generatedLotteryPaper = lotteryPaperFactory.generateLotteryPaper(listOf())

        Assertions.assertThat(generatedLotteryPaper.getLottoNumber()).hasSize(6).allMatch { it in 1..45 }
    }

    @Test
    fun `생성된 로또 번호는 중복이 없다`() {
        val lotteryPaperList = listOf(
            LotteryPaper(listOf(1, 2, 3, 4, 5, 6)), LotteryPaper(listOf(1, 2, 3, 4, 5, 7))
        )

        val generatedLotteyPaper = lotteryPaperFactory.generateLotteryPaper(lotteryPaperList)

        Assertions.assertThat(lotteryPaperList.contains(generatedLotteyPaper)).isEqualTo(false)
    }
}
