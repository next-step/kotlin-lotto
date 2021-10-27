package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46, 100])
    fun `1미만이나 45초과의 숫자가 로또 번호로 입력되면 IllegalArgumentException이 발생한다`(number: Int) {
        Assertions.assertThatThrownBy {
            LottoNumber(number)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `1이상 45이하의 숫자가 로또 번호로 입력되면 정상적인 LottoNumber가 생성된다`() {
        IntRange(1, 45).forEach { number ->
            val lottoNumber = LottoNumberPool[number]
            assertThat(lottoNumber).isNotNull
            assertThat(lottoNumber.value).isEqualTo(number)
            assertThat(lottoNumber).isEqualTo(LottoNumberPool[number])
        }
    }
}
