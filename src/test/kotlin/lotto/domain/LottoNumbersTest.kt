package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumbersTest {
    @Test
    fun `로또 번호 - 개수(6개)가 일치하지 않는 경우에 대한 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5))) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 6개의 숫자여야 합니다.")
    }

    @Test
    fun `로또 번호 - 중복이 발생한 경우에 대한 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(5))) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 중복될 수 없습니다.")
    }

    @Test
    fun `로또 번호 - 오름차순 정렬이 아닌 경우에 대한 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { LottoNumbers(listOf(LottoNumber(6), LottoNumber(5), LottoNumber(4), LottoNumber(3), LottoNumber(2), LottoNumber(1))) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 오름차순으로 정렬되어야 합니다.")
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:THIRD", "1,2,3,4,7,8:FOURTH", "1,2,3,7,8,9:FIFTH", "1,2,7,8,9,10:MISS", "1,7,8,9,10,11:MISS", "7,8,9,10,11,12:MISS"], delimiter = ':')
    fun `로또 번호 - 순위 확인 테스트`(given: String, expected: String) {
        // given
        val lottoNumbers = LottoNumbers(given.split(",").map { LottoNumber(it.toInt()) })
        val winningNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))

        // when
        val actual = lottoNumbers.getLottoRank(winningNumbers)

        // then
        assertThat(actual).isEqualTo(LottoRank.valueOf(expected))
    }
}
