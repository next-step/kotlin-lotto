package lotto

import lotto.domain.LottoCommittee
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.NumberFormatException

class LottoCommitteeTest {
    @Test
    fun `당첨번호는 6 자리다`() {
        val winningNumbers = LottoCommittee.createWinningNumbers("1,2,3,4,5,6")
        Assertions.assertThat(winningNumbers.size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,b,1,2,3,4", "1,10,33,a,36,5", ", ,1,2,3,4", ])
    fun `공백 혹은 숫자가 아닌 값이 입력되면 예외가 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoCommittee.createWinningNumbers(input)
        }
            .isInstanceOf(NumberFormatException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,0,1,2,3,4", "1,2,3,4,5,46"])
    fun `1 미만 45 초과 값이 들어가면 예외가 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoCommittee.createWinningNumbers(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력 값에 문제가 있습니다.")
    }

    @Test
    fun `3개를 맞춘 통계를 구할 수 있다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val statistics = LottoCommittee.createStatistics(listOf(listOf(4, 5, 6, 7, 8, 9)), winningNumbers)
        Assertions.assertThat(statistics[3]).isEqualTo(1)
    }

    @Test
    fun `6개를 맞춘 통계를 구할 수 있다`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val statistics = LottoCommittee.createStatistics(listOf(winningNumbers), winningNumbers)
        Assertions.assertThat(statistics[6]).isEqualTo(1)
    }
}
