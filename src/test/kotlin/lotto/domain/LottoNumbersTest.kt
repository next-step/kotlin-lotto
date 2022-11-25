package lotto.domain

import lotto.domain.LottoNumbers.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    // given
    private val lottoNumbers = LottoNumbers()

    @DisplayName("로또 번호 개수(6개) 확인 테스트")
    @Test
    fun `로또 번호 개수 확인 테스트`() {
        // when
        val actual = lottoNumbers.value.size

        // then
        assertThat(actual).isEqualTo(MAXIMUM_LOTTO_NUMBER_LENGTH)
    }

    @DisplayName("로또 번호 중복 확인 테스트")
    @Test
    fun `로또 번호 중복 확인 테스트`() {
        // when
        val actual = lottoNumbers.value

        // then
        assertThat(actual).doesNotHaveDuplicates()
    }
}
