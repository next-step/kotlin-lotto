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
        winningNumber = getLotto("1 2 3 4 5 6")
    }

    @ParameterizedTest
    @CsvSource(
        "1 2 3 4 5 6, FIRST, 1",
        "1 2 3 4 5 45, SECOND, 1",
        "1 2 3 4 5 16, THIRD, 2",
        "1 2 3 4 25 16, FOURTH, 1",
        "1 2 3 44 25 16, FIFTH, 1",
        "11 22 33 44 25 16, MISS, 3"
    )
    fun `당첨 로또와 비교하여 일치하는 등수와 갯수를 가져온다`(numbers: String, nameOfRank: String, count: Int) {
        val winningLotto = WinningLotto(winningNumber, LottoNumber(45))
        val numberList = mutableListOf("1 3 4 5 32 6", "11 12 13 14 6 7", "13 14 15 16 17 45")
        numberList.add(numbers)
        val myLottos = numberList.map { getLotto(it) }
        val matchResult = winningLotto.getMatchResult(myLottos)
        assertThat(matchResult[Rank.valueOf(nameOfRank)]).isEqualTo(count)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 6])
    fun `당첨 로또와 보너스 볼이 같으면 예외 발생`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException> { WinningLotto(winningNumber, LottoNumber(bonusNumber)) }
    }

    private fun getLotto(numbers: String): Lotto = Lotto(numbers.split(" ").map { LottoNumber(it.toInt()) }.toSet())
    private fun getLottos(numbers: String): List<Lotto> = listOf(getLotto(numbers))
}
