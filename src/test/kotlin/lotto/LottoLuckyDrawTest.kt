package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
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

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, 6"])
    internal fun `당첨 테스트`(input: String) {
        val lottoList = listOf(LottoNumber(listOf(1, 2, 3, 4, 5, 6)))
        LottoLuckyDraw(input).draw(lottoList)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, -6", "2, 3, 4, 5, 66", "5, -1, 6, 7, 8, 9"])
    fun `당첨번호 에러 처리 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { LottoLuckyDraw(input) }
    }
}
