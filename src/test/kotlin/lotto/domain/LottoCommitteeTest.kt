package lotto.domain

import lotto.domain.enum.Priority
import lotto.domain.`interface`.LottoFixedNumbers
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.NumberFormatException

class LottoCommitteeTest {
    @Test
    fun `당첨번호는 6 자리다`() {
        val winningTicket = LottoCommittee.createWinningTicket("1,2,3,4,5,6", "7")
        assertThat(winningTicket.numbers.size).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,b,1,2,3,4", "1,10,33,a,36,5", ", ,1,2,3,4", ])
    fun `당첨번호에 공백 혹은 숫자가 아닌 값이 입력되면 예외가 발생한다`(input: String) {
        assertThatThrownBy {
            LottoCommittee.createWinningTicket(input, "45")
        }
            .isInstanceOf(NumberFormatException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,0,1,2,3,4", "1,2,3,4,5,46"])
    fun `당첨번호에 1 미만 45 초과 값이 들어가면 예외가 발생한다`(input: String) {
        assertThatThrownBy {
            LottoCommittee.createWinningTicket(input, "10")
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호가 유효 범위내에 있지 않습니다.")
    }

    @Test
    fun `3개를 맞춘 통계를 구할 수 있다`() {
        val winningTicket = LottoCommittee.createWinningTicket("1,2,3,4,5,6", "7")
        val lottos = Lottos(listOf(LottoTicket(LottoFixedNumbers().createNumbers(listOf(4, 5, 6, 7, 8, 9)))))

        val statistics = LottoCommittee.calculateStatistics(lottos, winningTicket)

        assertThat(statistics[Priority.FIFTH]).isEqualTo(1)
    }

    @Test
    fun `6개를 맞춘 통계를 구할 수 있다`() {
        val winningTicket = LottoCommittee.createWinningTicket("1,2,3,4,5,6", "7")
        val lottos = Lottos(listOf(LottoTicket(LottoFixedNumbers().createNumbers(winningTicket.numbers.toList()))))

        val statistics = LottoCommittee.calculateStatistics(lottos, winningTicket)

        assertThat(statistics[Priority.FIRST]).isEqualTo(1)
    }

    @Test
    fun `3개를 맞춘 수익률을 구할 수 있다`() {
        val matchCount = 5
        val price = 15_000
        val priorities = mapOf(Priority.FIFTH to matchCount, Priority.FOURTH to 0, Priority.THIRD to 0, Priority.FIRST to 0)
        val expect = (Priority.getPrice(3)) * matchCount

        val returnRate = LottoCommittee.calculateReturnRate(price, priorities)

        assertThat(returnRate).isEqualTo(expect / price.toDouble())
    }

    @Test
    fun `6개를 맞춘 수익률을 구할 수 있다`() {
        val matchCount = 1
        val price = 1_000
        val priorities = mapOf(Priority.FOURTH to 0, Priority.THIRD to 0, Priority.SECOND to 0, Priority.FIRST to matchCount)
        val expect = Priority.getPrice(6) * matchCount

        val returnRate = LottoCommittee.calculateReturnRate(price, priorities)

        assertThat(returnRate).isEqualTo(expect / 1000.toDouble())
    }
}
