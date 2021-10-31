package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ValueSource(ints = [1, 24, 15, 16, 45])
    @ParameterizedTest
    @DisplayName("로또 번호 범위가 1~45 사이로 잘 나오는 경우")
    fun `correct lotto number range`(number: Int) {
        val lottoNumber = LottoNumber(number)

        Assertions.assertThat(lottoNumber.number).isBetween(1, 45)
    }

    @ValueSource(ints = [0, -199, 100, 46])
    @ParameterizedTest
    @DisplayName("로또 번호 범위를 벗어나는 경우")
    fun `incorrect lotto number range`(number: Int) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoNumber(number) }
            .withMessage(LottoNumber.EXCEPTION_NUMBER_FORMAT)
    }
}
