package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 45, 12, 31, 42])
    fun `LottoNumber는 로또 번호를 표현하는 숫자를 보관한다`(input: Int) {
        val lottoNumber = LottoNumber(input)

        assertThat(lottoNumber.value).isEqualTo(input)
    }
}
