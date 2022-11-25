package lotto.domain

import lotto.domain.LottoBuyingStrategy.Companion.LOTTO_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPriceTest {
    @DisplayName("로또 생성자 예외 테스트")
    @Test
    fun `로또 생성자 예외 테스트`() {
        // given, when, then
        assertThatThrownBy { LottoPrice(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 구입 금액은 ${LOTTO_PRICE}원 이상이어야 합니다.")
    }

    @DisplayName("로또 부생자 예외 테스트")
    @Test
    fun `로또 부생성자 예외 테스트`() {
        // given, when, then
        assertThatThrownBy { LottoPrice("Lotto") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자 이외의 값은 입력할 수 없습니다.")
    }

    @DisplayName("로또 구입 개수 테스트")
    @ParameterizedTest
    @CsvSource(value = ["1000:1", "1001:1", "9999:9", "10000:10"], delimiter = ':')
    fun `로또 구입 개수 테스트`(given: Int, expected: Int) {
        // given
        val lottoPrice = LottoPrice(given)

        // when
        val actual = lottoPrice.count()

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
