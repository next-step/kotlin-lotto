package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTest {
    @Test
    fun `LottoNumbers는 LottoNumber 객체 6개로 만들어진다`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        ).toSet()

        // when, then
        assertDoesNotThrow { Lotto(lottoNumbers) }
    }

    @Test
    fun `서로 다른 숫자 6개를 인자로 주면 LottoNumbers를 만든다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val lottoNumbers = Lotto(numbers)

        // then
        assertThat(lottoNumbers).isEqualTo(
            Lotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                ).toSet()
            )
        )
    }

    @Test
    fun `LottoNumber의 갯수가 6개가 아니면 예외가 발생한다`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5)
        ).toSet()

        // when, then
        assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) }
    }

    @Test
    fun `같은 LottoNumbers에 속하는 6개의 로또 번호는 모두 달라야 한다`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(5)
        ).toSet()

        // when, then
        assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) }
    }

    @Test
    fun `당첨번호를 인자로 주면, 몇 개가 당첨번호와 일치하는지 반환한다`() {
        // given
        val myLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val count = myLotto.getWinningCount(Lotto(listOf(1, 2, 3, 4, 5, 7)))

        // then
        assertThat(count).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, 6", "1,2,3,4,5,6"])
    fun `콤마로 구분한 숫자 6개 문자열을 인자로 주면, 하나의 Lotto 객체가 생성된다`(winningNumberString: String) {
        // when
        val lotto = Lotto(winningNumberString)

        // then
        assertThat(lotto).isEqualTo(Lotto(listOf(1, 2, 3, 4, 5, 6)))
    }

    @ParameterizedTest
    @CsvSource(value = ["1:true", "2:true", "6:true", "7:false"], delimiter = ':')
    fun `LottoNumber 하나를 인자로 주면, Lotto에 포함된 숫자인지 아닌지 반환한다`(num: String, expectedHasNumber: Boolean) {
        // given
        val lotto = Lotto("1,2,3,4,5,6")

        // when
        val hasNumber: Boolean = lotto.hasNumber(num)

        // then
        assertThat(hasNumber).isEqualTo(expectedHasNumber)
    }
}
