package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = [5000])
    fun `당첨 번호와 발급한 로또 번호를 비교하여 갯수별로(3개~6개) 당첨 개수를 산정할 수 있다`(money: Int) {
        val lottoBundle = listOf(listOf(1, 2, 3, 4, 5, 7), listOf(2, 14, 26, 11, 4, 22), listOf(5, 7, 17, 21, 33, 31))
        val winningNumber = "1, 2, 3, 4, 5, 7"
        val actual = LottoChecker().lottoCheck(winningNumber, lottoBundle)
        Assertions.assertThat(actual[0]).isEqualTo(6)
        Assertions.assertThat(actual[1]).isEqualTo(2)
        Assertions.assertThat(actual[2]).isEqualTo(2)
    }

    @Test
    fun `당첨 개수를 전달 받아 당첨 금액을 산정할 수 있다`() {
        val collectCounts = listOf(3, 1, 3)
        val actual = LottoChecker().winningMoneyCheck(collectCounts)
        Assertions.assertThat(actual).isEqualTo(10000)
    }
}
