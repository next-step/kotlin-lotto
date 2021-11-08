package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoWinCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100])
    fun `주어진 로또들의 당첨결과를 반환한다`(lottoCount: Int) {
        val lottos = (0..lottoCount).map {
            Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        }
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(7)

        val results = LottoWinChecker(lottos).getPrizes(winningNumbers, bonusNumber)

        assertThat(results.size).isEqualTo(lottos.size)
    }

    @ParameterizedTest
    @CsvSource(
        "1,2,3,11,12,13|45|FIFTH",
        "1,2,3,4,11,12|45|FOURTH",
        "1,2,3,4,5,11|45|THIRD",
        "1,2,3,4,5,11|6|SECOND",
        "1,2,3,4,5,6|45|FIRST",
        delimiter = '|'
    )
    fun `맞춘 번호 개수에 맞는 당첨결과를 반환한다`(input: String, bonus: Int, expectedPrize: LottoPrize) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningNumbers = input.split(",").map { LottoNumber(it.toInt()) }
        val bonusNumber = LottoNumber(bonus)

        val results = LottoWinChecker(listOf(lotto)).getPrizes(winningNumbers, bonusNumber)

        assertThat(results.first()).isEqualTo(expectedPrize)
    }

    @ParameterizedTest
    @CsvSource("6,SECOND", "8,THIRD")
    fun `보너스 번호 일치 여부에 맞는 당첨결과를 반환한다`(bonus: Int, expectedPrize: LottoPrize) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(bonus)

        val results = LottoWinChecker(listOf(lotto)).getPrizes(winningNumbers, bonusNumber)

        assertThat(results.first()).isEqualTo(expectedPrize)
    }

    @Test
    fun `이미 당첨번호로 사용된 보너스 번호를 받으면 에러를 일으킨다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val winningNumbers = listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(1)

        assertThrows<IllegalArgumentException> {
            LottoWinChecker(listOf(lotto)).getPrizes(winningNumbers, bonusNumber)
        }
    }
}
