package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoNumTest {
    @ParameterizedTest
    @CsvSource(value = ["1,1", "2, 2", "44,44", "45,45"])
    fun `로또 숫자는 1~45 사이만 가능하다`(input: Int, expect: Int) {
        val lottoNum = LottoNum(input)

        assertThat(lottoNum.num).isEqualTo(expect)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46])
    fun `로또 숫자가 잘못되면 예외를 던진다`(input: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNum(input)
        }
    }
}
