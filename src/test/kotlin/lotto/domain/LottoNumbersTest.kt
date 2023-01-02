package lotto.domain

import lotto.model.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

internal class LottoNumbersTest {

    @Test
    fun `로또 번호는 6개의 숫자로 구성된다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)

        // when
        val lottoNumbers = LottoNumbers(numbers)

        // then
        assertThat(lottoNumbers.value).isEqualTo(numbers)
    }

    @Test
    fun `로또 번호는 6개의 숫자가 아니면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5).map(::LottoNumber)

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoNumbers(numbers) }
            .withMessage("로또 번호는 6개의 숫자로 구성되어야 합니다.")
    }

    @Test
    fun `로또 번호는 중복되는 숫자가 없어야 한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5).map(::LottoNumber)

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoNumbers(numbers) }
            .withMessage("로또 번호는 중복되는 숫자가 없어야 합니다.")
    }

    @Test
    fun `로또 번호 목록내 포함된 로또 번호 포함 여부를 알 수 있다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
        val lottoNumbers = LottoNumbers(numbers)
        val lottoNumber = LottoNumber(1)

        // when
        val contains = lottoNumbers.contains(lottoNumber)

        // then
        assertThat(contains).isTrue
    }

    @Test
    fun sort() {
        // given
        val numbers = listOf(6, 5, 4, 3, 2, 1).map(::LottoNumber)
        val lottoNumbers = LottoNumbers(numbers)

        // when
        val sortedLottoNumbers = lottoNumbers.sort()

        // then
        assertThat(sortedLottoNumbers.value).isEqualTo(numbers.sortedBy { it.value })
    }
}
