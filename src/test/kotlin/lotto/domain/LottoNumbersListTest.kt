package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumbersListTest {
    @Test
    fun `로또 번호 리스트 - 리스트 반환 테스트`() {
        // given
        val lottoNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))
        val lottoNumbersList = LottoNumbersList(listOf(lottoNumbers))

        // when
        val actual = lottoNumbersList.getList()

        // then
        assertThat(actual).contains(listOf(1, 2, 3, 4, 5, 6))
    }
}
