package lotto.domain

import lotto.util.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [Int.MIN_VALUE, 0, 46, Int.MAX_VALUE])
    fun `lottoNumber throw Exception when not between 1 and 45`(lottoNumber: Int) {
        val exception = assertThrows<IllegalArgumentException> {
            LottoNumber(number = lottoNumber)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_NUMBER_EXEPTION.errorMessage)
    }

    @Test
    fun `lottoNumber equal when number is the same`() {
        val number = 2
        val lottoNumber1 = LottoNumber(number)
        val lottoNumber2 = LottoNumber(number)

        val result = listOf(lottoNumber1).contains(lottoNumber2)

        assertThat(result).isTrue
    }
}
