package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoWinCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100])
    fun `주어진 로또들의 당첨결과를 반환한다`(lottoCount: Int) {
        val lottos = (0..lottoCount).map { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        val results = LottoWinChecker(lottos).getPrizes(winningNumbers)

        assertThat(results.size).isEqualTo(lottos.size)
    }

    @ParameterizedTest
    @CsvSource("1,2,3,11,12,13|FOURTH", "1,2,3,4,11,12|THIRD", "1,2,3,4,5,11|SECOND", "1,2,3,4,5,6|FIRST", delimiter = '|')
    fun `맞춘 번호 개수에 맞는 당첨결과를 반환한다`(input: String, expectedPrize: LottoPrize) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = input.split(",").map { it.toInt() }

        val results = LottoWinChecker(listOf(lotto)).getPrizes(winningNumbers)

        assertThat(results.first()).isEqualTo(expectedPrize)
    }
}
