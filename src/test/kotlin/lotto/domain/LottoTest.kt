package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `잘못된 개수의 번호로 로또 생성 시 에러를 일으킨다`(numbers: String) {
        val numberBalls = numbers.split(",").map { LottoNumber(it.toInt()) }
        assertThrows<IllegalArgumentException> {
            Lotto(numberBalls)
        }
    }

    @Test
    fun `중복된 번호로 로또 생성 시 에러를 일으킨다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 2, 3, 4, 5).map { LottoNumber(it) })
        }
    }

    @ParameterizedTest
    @CsvSource("1,2,3|3", "1,2,3,4|4", "1,2,3,4,5|5", "1,2,3,4,5,6|6", delimiter = '|')
    fun `당첨번호를 입력하면 일치하는 번호 개수를 리턴한다`(winningNumbers: String, expectedCount: Int) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val matchedCount = lotto.countMatches(
            winningNumbers
                .split(",")
                .map { LottoNumber(it.toInt()) }
        )

        assertThat(matchedCount).isEqualTo(expectedCount)
    }

    @ParameterizedTest
    @CsvSource("1,true", "10,false")
    fun `보너스 번호를 입력하면 일치 여부를 리턴한다`(bonusNumber: Int, expectedResult: Boolean) {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        val matched = lotto.checkBonusMatch(bonusNumber = LottoNumber(bonusNumber))

        assertThat(matched).isEqualTo(expectedResult)
    }
}
