package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또 번호")
internal class LottoNumberTest {

    @ParameterizedTest(name = "로또 번호 {0}")
    @ValueSource(ints = [1, 2, 44, 45])
    fun `1 ~ 45 사이의 정상 범위 숫자 생성`(number: Int) {
        val lottoNumber = LottoNumber(number)
        assertThat(lottoNumber.number).isEqualTo(number)
    }

    @ParameterizedTest(name = "로또 번호 {0}")
    @ValueSource(ints = [-1, 0, 46, Int.MAX_VALUE])
    fun `1 ~ 45 이외의 범위 숫자 생성시 예외 발생`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(number) }
    }
}
