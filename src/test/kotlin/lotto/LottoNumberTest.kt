package lotto

import io.kotest.assertions.throwables.shouldThrow
import lotto.domain.LottoNumber
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumberTest {

    @ParameterizedTest
    @CsvSource("-1", "0", "46", "1111")
    fun `로또 번호가 1~45 사이에 포함되지 않는 경우 IllegalArgumentException 을 발생`(lottoNumber: Int) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(lottoNumber)
        }
    }
}
