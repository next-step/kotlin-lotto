package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumTest {
    @ParameterizedTest
    @CsvSource(value = ["1,1", "2, 2", "44,44", "45,45"])
    fun `로또 숫자는 1~45 사이만 가능하다`(input: Int, expect: Int) {
    }

    @Test
    fun `로또 숫자가 잘못되면 예외를 던진다`() {
    }
}
