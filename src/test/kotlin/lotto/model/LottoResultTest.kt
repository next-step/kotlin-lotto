package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoResultTest {

    @DisplayName("같은 번호가 5개 일치하면 2등이 된다.")
    @Test
    fun lottoResultWinners() {
        val lotto = LottoCreator.manualZeroPrice(1, 2, 3, 4, 5, 6)
        val winLottoNumbers = LottoNumbers.manual(1, 2, 3, 4, 5, 10)
        val bonus = LottoNumber(45)
        val result = LottoResult.of(listOf(lotto), winLottoNumbers, bonus)

        val expected = 1
        val actual = result.winners(LottoRank.Second)

        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("14,000원으로 5,000원을 얻으면 수익률은 0.35가 된다.")
    @Test
    fun lottoRateOfReturn() {
        val lotto = LottoCreator.manual(price = 14000, 1, 2, 3, 4, 5, 6)
        val winLottoNumbers = LottoNumbers.manual(1, 2, 3, 10, 11, 12)
        val bonus = LottoNumber(45)
        val result = LottoResult.of(listOf(lotto), winLottoNumbers, bonus)

        val expected = 0.35f
        val actual = result.rateOfReturn
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("당첨 로또와 보너스 볼의 숫자가 중복되면 RuntimeException 예외가 발생한다.")
    @Test
    fun lottoResultDuplicateBonus() {
        val lotto = LottoCreator.manualZeroPrice(1, 2, 3, 4, 5, 6)
        val winLottoNumbers = LottoNumbers.manual(1, 2, 3, 4, 5, 6)
        val bonus = LottoNumber(1)

        assertThrows<RuntimeException> {
            LottoResult.of(listOf(lotto), winLottoNumbers, bonus)
        }
    }

    @DisplayName("번호가 5개 일치한 상태에서 보너스 볼을 맞추면 2등이 된다.")
    @Test
    fun lottoResultSecondRank() {
        val lotto = LottoCreator.manualZeroPrice(1, 2, 3, 4, 5, 7)
        val win = LottoNumbers.manual(1, 2, 3, 4, 5, 6)
        val bonus = LottoNumber(7)
        val result = LottoResult.of(listOf(lotto), win, bonus)

        val expected = 1
        val actual = result.winners(LottoRank.Second)
        assertThat(actual).isEqualTo(expected)
    }
}
