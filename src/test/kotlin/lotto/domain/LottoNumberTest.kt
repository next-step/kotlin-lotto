package lotto.domain

import lotto.domain.model.LottoNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ValueSource(ints = [1, 2, 3, 4, 5])
    @ParameterizedTest
    fun `toString 했을때 숫자만 나온다`(number: Int) {
        val lottoNumber = LottoNumber(number)
        val actual = lottoNumber.toString()

        assertEquals(number.toString(), actual)
    }
}
