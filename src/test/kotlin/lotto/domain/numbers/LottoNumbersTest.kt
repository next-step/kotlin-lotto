package lotto.domain.numbers

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Nested
    inner class `랜덤으로 생성될 경우` {
        @Test
        fun `총 6개의 랜덤 숫자로 구성되어 있다`() {
            val lottoNumbers = LottoNumbers().list
            assertThat(lottoNumbers).hasSize(6)
        }

        @Test
        fun `생성된 숫자는 1과 45 사이의 번호로 이루어져 있다`() {
            val lottoNumbers = LottoNumbers().list
            assertThat(lottoNumbers).allMatch { it in (1..45) }
        }
    }

    @Nested
    inner class `사용자가 입력한 숫자로 생성될 경우` {
        @Test
        fun `사용자가 입력한 6개의 숫자를 반환한다`() {
            val customLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
            val lottoNumbers = LottoNumbers(customLottoNumbers)

            assertThat(lottoNumbers.list)
                .hasSize(6)
                .isEqualTo(customLottoNumbers)
        }

        @Test
        fun `총 6개의 숫자가 주어지지 않을 경우 IllegalArgumentException 을 반환한다`() {
            val moreThanSix = listOf(1, 2, 3, 4, 5, 6, 7)
            val lessThanSix = listOf(1, 2, 3, 4, 5)

            assertThatIllegalArgumentException().isThrownBy { LottoNumbers(moreThanSix) }
            assertThatIllegalArgumentException().isThrownBy { LottoNumbers(lessThanSix) }
        }

        @Test
        fun `1 과 45 사이의 숫자가 아닐 경우 IllegalArgumentException 을 반환한다`() {
            val lessThanOneLottoNumber = listOf(0, 2, 3, 4, 5, 6)
            val greaterThanFortyFiveLottoNumber = listOf(1, 2, 3, 4, 5, 46)

            assertThatIllegalArgumentException().isThrownBy { LottoNumbers(lessThanOneLottoNumber) }
            assertThatIllegalArgumentException().isThrownBy { LottoNumbers(greaterThanFortyFiveLottoNumber) }
        }
    }
}
