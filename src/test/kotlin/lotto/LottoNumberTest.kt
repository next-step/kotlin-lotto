package lotto

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest(name = "1~45 사이의 숫자를 가진 로또를 생성할 수 있다.")
    @CsvSource(value = ["1, 1", "2, 2", "3, 3", "4, 4", "5, 5", "6, 6", "7, 7"])
    fun `1~45 사이의 숫자를 가진 로또 번호를 생성할 수 있다`(value: Int, expected: Int) {
        assertThat(LottoNumber(value)).isEqualTo(LottoNumber(expected))
    }

    @ParameterizedTest(name = "1~45 사이의 숫자가 아니라면 Exception을 발생시킨다")
    @ValueSource(ints = [0, 46, 47, 48])
    fun `1~45사이의 숫자가 아닌 번호를 입력하면 IllegalArgumentException을 발생시킨다`(value: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(value) }
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoNumber(value)
        }.withMessage(LottoNumber.WRONG_LOTTO_NUM_MESSAGE)
    }
}
