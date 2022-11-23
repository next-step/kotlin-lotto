package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningLottoTest {

    @ParameterizedTest
    @CsvSource("1 2 3 4 5 6, 6", "1 2 3 4 5 16, 5", "1 2 3 4 25 16, 4", "1 2 3 44 25 16, 3", "11 22 33 44 25 16, 0")
    fun `당첨 로또와 비교하여 일치하는 번호의 갯수를 가져온다`(numbers: String, countOfMatch: Int) {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()))
        val myLottoNumbers = Lotto(numbers.split(" ").map { LottoNumber(it.toInt()) }.toSet())
        assertThat(winningLotto.getCountOfMatch(myLottoNumbers)).isEqualTo(countOfMatch)
    }
}
