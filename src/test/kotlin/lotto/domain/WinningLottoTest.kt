package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WinningLottoTest {

    private lateinit var winningNumber: Lotto

    @BeforeAll
    fun setup() {
        winningNumber = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet())
    }

    @ParameterizedTest
    @CsvSource("1 2 3 4 5 6, 6", "1 2 3 4 5 16, 5", "1 2 3 4 25 16, 4", "1 2 3 44 25 16, 3", "11 22 33 44 25 16, 0")
    fun `당첨 로또와 비교하여 일치하는 번호의 갯수를 가져온다`(numbers: String, countOfMatch: Int) {
        val winningLotto = WinningLotto(winningNumber, LottoNumber(45))
        val myLottoNumbers = Lotto(numbers.split(" ").map { LottoNumber(it.toInt()) }.toSet())
        val matchResult = winningLotto.getMatchResult(myLottoNumbers)
        assertThat(matchResult.countOfMatch).isEqualTo(countOfMatch)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 6])
    fun `당첨 로또와 보너스 볼이 같으면 예외 발생`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException> { WinningLotto(winningNumber, LottoNumber(bonusNumber)) }
    }

    @ParameterizedTest
    @CsvSource("11,true", "23,true", "36,true", "44,false", "21,false", "35,false")
    fun `보너스 볼의 일치 여부 값을 가진다`(bonusNumber: Int, matchBonus: Boolean) {
        val myLotto = Lotto(listOf(11, 12, 23, 14, 15, 36).map { LottoNumber(it) }.toSet())
        val matchResult = WinningLotto(winningNumber, LottoNumber(bonusNumber)).getMatchResult(myLotto)
        assertThat(matchResult.matchBonus).isEqualTo(matchBonus)
    }
}
