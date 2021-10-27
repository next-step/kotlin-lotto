package lotto.utils

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4"])
    fun `문자를 숫자로 리턴한다`(givenText: String) {
        val number = StringUtils.toNumber(givenText)

        assertThat(number).isEqualTo(givenText.toInt())
    }

    @Test
    fun `컴마(,)를 기준으로 로또 번호로 리턴한다`() {
        val givenText = "1,2,3,4,5,6"

        val lottoNumbers = StringUtils.toLottoNumbers(givenText)

        assertThat(lottoNumbers).containsExactly(
            LottoNumber.valueOf(1),
            LottoNumber.valueOf(2),
            LottoNumber.valueOf(3),
            LottoNumber.valueOf(4),
            LottoNumber.valueOf(5),
            LottoNumber.valueOf(6)
        )
    }
}
