package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 20, 30, 45])
    fun `숫자를 입력받아 로또 번호를 생성할 수 있다`(givenNumber: Int) {
        val lottoNumber = LottoNumber.valueOf(givenNumber)

        assertThat(lottoNumber).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `1 ~ 45 사이 숫자가 아니라면 예외를 던진다`(givenNumber: Int) {
        assertThatCode { LottoNumber.valueOf(givenNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
