package lotto

import lotto.enums.LottoRank
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = [5000])
    fun `당첨 번호와 발급한 로또 번호를 비교하여 갯수별로(3개~6개) 당첨 개수를 산정할 수 있다`(money: Int) {
        val lottoBundle = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)), Lotto(listOf(2, 4, 5, 11, 18, 22)))
        val winningNumber = "1, 2, 3, 4, 5, 7"
        val actual = LottoChecker().lottoCheck(winningNumber, lottoBundle)
        Assertions.assertThat(actual[0]).isEqualTo(LottoRank.SIX_COLLECT)
        Assertions.assertThat(actual[1]).isEqualTo(LottoRank.THREE_COLLECT)
    }

    @Test
    fun `당첨 개수를 전달 받아 당첨 금액을 산정할 수 있다`() {
        val collectLottoRanks = listOf(LottoRank.THREE_COLLECT, LottoRank.FOUR_COLLECT)
        val actual = LottoChecker().winningMoneyCheck(collectLottoRanks)
        Assertions.assertThat(actual).isEqualTo(55000)
    }
}
