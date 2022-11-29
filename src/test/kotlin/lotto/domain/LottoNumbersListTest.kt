package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumbersListTest {
    // given
    private val lottoNumbers = LottoNumbers(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6)))

    @BeforeEach
    fun setUp() {
        // givens
        LottoNumbersList.setLottoNumbers(lottoNumbers)
    }

    @DisplayName("getLottoNumbers() 메서드 테스트")
    @Test
    fun `getLottoNumbers() 메서드 테스트`() {
        // when
        val actual = LottoNumbersList.getLottoNumbers()

        // then
        assertThat(actual).contains(lottoNumbers)
    }

    @DisplayName("getList() 메서드 테스트")
    @Test
    fun `getList() 메서드 테스트`() {
        // when
        val actual = LottoNumbersList.getList()

        // then
        assertThat(actual).contains(listOf(1, 2, 3, 4, 5, 6))
    }
}
