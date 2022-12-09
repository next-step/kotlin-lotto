package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumbersListTest {
    @Test
    fun `로또 번호 리스트 - 리스트 반환 테스트`() {
        // given
        val lottoNumbers = LottoNumbers(listOf(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)))
        val lottoNumbersList = LottoNumbersList(listOf(lottoNumbers))

        // when
        val actual = lottoNumbersList.getList()

        // then
        assertThat(actual).contains(listOf(1, 2, 3, 4, 5, 6))
    }
}
