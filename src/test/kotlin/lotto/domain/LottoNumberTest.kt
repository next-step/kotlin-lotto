package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 45])
    fun `1~45 사이에 숫자를 넣으면 동일성이 보장되는 로또넘버가 생성된다`(
        givenNumber: Int,
    ) {
        // Given
        val lottoNumber = LottoNumber.from(givenNumber)

        // when
        val actual = LottoNumber.from(givenNumber)

        // Then
        assertThat(actual).isSameAs(lottoNumber)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46, 47, -1, -2, -3, -10, -100])
    fun `주입받는 정수가 0 또는 음수이거나 45를 초과하면 에러를 반환한다`(
        givenNumber: Int
    ) {
        assertThrows<IllegalArgumentException> {
            LottoNumber.from(givenNumber)
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["1|1|true", "1|9|false"], delimiter = '|')
    fun `생성된 로또번호와 비교대상인 숫자가 같은지 여부를 반환한다`(
        givenNumber: Int,
        matchNumber: Int,
        isMatch: Boolean,
    ) {
        // Given & When
        val actual = LottoNumber.from(givenNumber)

        // Then
        assertThat(actual == LottoNumber.from(matchNumber)).isEqualTo(isMatch)
    }
}
