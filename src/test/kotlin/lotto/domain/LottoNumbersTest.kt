package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @DisplayName("로또 번호 개수(6개) 예외처리 테스트")
    @Test
    fun `로또 번호 개수 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5))) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 6개의 숫자여야 합니다.")
    }

    @DisplayName("로또 번호 중복 예외처리 테스트")
    @Test
    fun `로또 번호 중복 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(5))) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 중복될 수 없습니다.")
    }

    @DisplayName("로또 번호 오름차순 정렬 예외처리 테스트")
    @Test
    fun `로또 번호 오름차순 정렬 예외처리 테스트`() {
        // given, when, then
        assertThatThrownBy { LottoNumbers(listOf(LottoNumber(6), LottoNumber(5), LottoNumber(4), LottoNumber(3), LottoNumber(2), LottoNumber(1))) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 오름차순으로 정렬되어야 합니다.")
    }

    @DisplayName("로또 순위 확인 테스트")
    @Test
    fun `로또 순위 확인 테스트`() {
        // given
        val lottoNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
        val winningNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))

        // when
        val actual = lottoNumbers.getLottoRank(winningNumbers)

        // then
        assertThat(actual).isEqualTo(LottoRank.FIRST)
    }
}
