package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoLuckyDrawTest {

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, 6"])
    fun `당첨번호 숫자로 만들기`(input: String) {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6)
        val luckyDrawNumber = LottoLuckyDraw(input).luckyNumber
        assertThat(luckyDrawNumber).isEqualTo(lottoNumber)
    }
}