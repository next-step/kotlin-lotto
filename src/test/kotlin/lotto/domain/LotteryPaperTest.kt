package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LotteryPaperTest {
    @ParameterizedTest
    @ValueSource(ints = [12000, 1000, 5000])
    fun `들어온 금액에 맞추어 lottoGame을 만들어낸다`(money: Int) {
        val paper = LotteryPaper(LottoNumberSelectPaper(LottoBudget(money),))
        val expected = money / LottoBudget.PRICE_OF_GAME
        val actual = paper.getNumberOfGames()
        assertThat(actual).isEqualTo(expected)
    }
}
