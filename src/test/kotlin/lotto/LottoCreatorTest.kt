package lotto

import IssueStrategy
import RandomIssueStrategy
import lotto.LottoCreator.createLottoTickets
import lotto.LottoCreator.issue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoCreatorTest {

    @Test
    fun `로또를 설정한 횟수에 맞게 랜덤하게 발급한다`() {
        val count = 3

        var strategy = RandomIssueStrategy(count)
        assertThat(issue(strategy).size).isEqualTo(count)
    }

    @Test
    fun `발급된 숫자에 중복이 없어야 한다`() {
        var strategy = IssueStrategy { listOf(LottoTicket(listOf(LottoNumber(1)
            , LottoNumber(2)
            , LottoNumber(3)
            , LottoNumber(4)
            , LottoNumber(5)
            , LottoNumber(6)
        ))) }

        val randomIssuedList = issue(strategy)
        assertThat(randomIssuedList.distinct().size).isEqualTo(randomIssuedList.size)
    }

    @Test
    fun `사용자가 수동으로 입력한 로또를 발급할 때 공백을 제거해야한다`() {
        val list = listOf("1,2, 3,4,5, 6")
        val lottoTickets = createLottoTickets(list)

        assertThat(lottoTickets.size).isEqualTo(1)
        assertThat(lottoTickets.get(0).ticketList.get(2)).isEqualTo(LottoNumber(3))
    }
}
