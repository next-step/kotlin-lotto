package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    @DisplayName("로또를 생성하면 중복되지 않은 6개의 숫자를 반환한다")
    @Test
    fun createLottoTest() {
        // given
        val lotto = Lotto()

        // when
        val numbers = lotto.numbers

        // then
        assertThat(numbers.distinct()).hasSize(6)
        assertThat(numbers).isEqualTo(numbers.sortedBy { it.number })
    }

    @DisplayName("당첨 번호와 구매한 로또 번호의 일치 개수를 반환한다")
    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,4,5,6:1,2,3,4,5,6:6",
            "1,2,3,4,5,6:1,2,3,4,5,7:5",
            "1,2,3,4,5,6:1,2,3,4,7,8:4",
            "1,2,3,4,5,6:1,2,3,7,8,9:3",
            "1,2,3,4,5,6:1,2,7,8,9,10:2",
            "1,2,3,4,5,6:1,7,8,9,10,11:1",
            "1,2,3,4,5,6:7,8,9,10,11,12:0",
        ],
        delimiter = ':')
    fun matchCountTest(winningLottoNumbers: String, userLottoNumbers: String, expected: Int) {
        // given
        val userLotto = Lotto(userLottoNumbers.split(",").map { LottoNumber(it.toInt()) })
        val winningLotto = Lotto(winningLottoNumbers.split(",").map { LottoNumber(it.toInt()) })

        // when
        val actual = userLotto.match(winningLotto)

        // then
        assertThat(actual.countOfMatch).isEqualTo(expected)
    }
}