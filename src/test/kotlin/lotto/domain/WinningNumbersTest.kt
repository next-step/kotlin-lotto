package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningNumbersTest {
    @DisplayName("WinningNumbers 생성 테스트")
    @Test
    fun `WinningNumbers 생성 테스트`() {
        // given
        val winningNumbers = WinningNumbers("1, 2, 3, 4, 5, 6")
        // when, then
        assertThat(winningNumbers).isEqualTo(WinningNumbers("1, 2, 3, 4, 5, 6"))
    }

    @DisplayName("WinningNumbers 생성 예외처리 테스트 - 개수 미일치(6개)")
    @ParameterizedTest
    @CsvSource(value = ["1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"])
    fun `WinningNumbers 생성 예외처리 테스트 - 개수 미일치`(input: String) {
        // when, then
        assertThatThrownBy { WinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("당첨 번호는 6개의 숫자여야 합니다.")
    }

    @DisplayName("WinningNumbers 예외처리 테스트 - 숫자 미입력")
    @Test
    fun `WinningNumbers 예외처리 테스트 - 숫자 미입력`() {
        // given, when, then
        assertThatThrownBy { WinningNumbers("Lotto") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자 이외의 값은 입력할 수 없습니다.")
    }

    @DisplayName("WinningNumbers 예외처리 테스트 - 중복 숫자 포함")
    @Test
    fun `WinningNumbers 예외처리 테스트 - 중복 숫자 포함`() {
        // given, when, then
        assertThatThrownBy { WinningNumbers("1, 2, 3, 4, 5, 5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("당첨 번호는 중복될 수 없습니다.")
    }

    @DisplayName("당첨 번호와 로또 번호가 일치하는 개수를 반환하는 테스트")
    @Test
    fun `당첨 번호와 로또 번호가 일치하는 개수를 반환하는 테스트`() {
        // given
        val winningNumbers = WinningNumbers("1, 2, 3, 4, 5, 6")
        val lottoNumbers = LottoNumbers("1, 2, 3, 7, 8, 9")

        // when
        val count = winningNumbers.contains(lottoNumbers)

        // then
        assertThat(count).isEqualTo(3)
    }
}
