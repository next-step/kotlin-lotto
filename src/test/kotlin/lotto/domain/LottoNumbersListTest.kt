package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoNumbersListTest {
    // given
    private val lottoNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))

    @BeforeEach
    fun setUp() {
        // givens
        LottoNumbersList.setLottoNumbers(lottoNumbers)
    }

    @Test
    fun `로또 번호 리스트 - 일급 콜렉션 반환 테스트`() {
        // when
        val actual = LottoNumbersList.getLottoNumbers()

        // then
        assertThat(actual).contains(lottoNumbers)
    }

    @Test
    fun `로또 번호 리스트 - 원시값 반환 테스트`() {
        // when
        val actual = LottoNumbersList.getList()

        // then
        assertThat(actual).contains(listOf(1, 2, 3, 4, 5, 6))
    }
}
