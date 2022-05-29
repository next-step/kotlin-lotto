package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 45, 15, 29, 32])
    internal fun `로또 번호는 1 ~ 45 사이로 생성해야 한다`(num: Int) {
        val actual = LottoNumber(num)
        assertThat(actual).isEqualTo(num)
    }

    @ParameterizedTest(name = "`{0}`인 경우 IllegalArgumentException 에러 발생")
    @ValueSource(ints = [0, -2, 46])
    internal fun `로또 번호가 숫자이고, 1 ~ 45 사이가 아니면 IllegalArgumentException 에러 발생`(num: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(num) }
    }

    @ParameterizedTest(name = "`{0}`인 경우 IllegalArgumentException 에러 발생")
    @NullAndEmptySource
    @ValueSource(strings = ["a", "!"])
    internal fun `입력한 값이 empty이거나 숫자가 아니면 IllegalArgumentException 에러 발생`(price: String?) {
        assertThrows<IllegalArgumentException> { LottoPrice(price) }
    }

    @Test
    internal fun `같은 값의 LottoNumber를 set에 넣으면 중복이다`() {
        val lottoNumber1 = LottoNumber(4)
        val lottoNumber2 = LottoNumber(4)

        val lottoNumbers = setOf(lottoNumber1, lottoNumber2)
        assertThat(lottoNumbers).hasSize(1)
    }
}
