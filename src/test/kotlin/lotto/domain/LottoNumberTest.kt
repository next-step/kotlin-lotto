package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @DisplayName("로또 번호는 1~45 사이의 숫자이다")
    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun lottoNumberShouldBeBetweenOneAndFortyFive(number: Int) {
        // given

        // when
        val actual = LottoNumber(number)

        // then
        assertThat(actual.number).isEqualTo(number)
    }

    @DisplayName("로또 번호는 1~45 사이의 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun lottoNumberShouldThrowExceptionWhenNumberIsNotBetweenOneAndFortyFive(number: Int) {
        // given

        // when
        val actual = assertThatCode { LottoNumber(number) }

        // then
        actual.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또 번호는 1~45 사이의 숫자입니다.")
    }
}