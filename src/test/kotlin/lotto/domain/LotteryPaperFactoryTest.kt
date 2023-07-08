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
        // given
        val generatedLotteryPaper = lotteryPaperFactory.generateLotteryPaper(listOf())
        // then
        Assertions.assertThat(generatedLotteryPaper.getLottoNumbers()).hasSize(6).allMatch { it.lottoNumber in 1..45 }
    }

    @Test
    fun `생성된 로또 번호는 중복이 없다`() {
        // given
        val lotteryPaperList = listOf(
            LotteryPaper(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            ),
            LotteryPaper(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(7)
                )
            )
        )

        // when
        val generatedLotteyPaper = lotteryPaperFactory.generateLotteryPaper(lotteryPaperList)

        // then
        Assertions.assertThat(lotteryPaperList.contains(generatedLotteyPaper)).isEqualTo(false)
    }
}
