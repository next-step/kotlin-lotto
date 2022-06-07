package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `로또 숫자와 매칭된 개수를 리턴한다`() {
        val issue = LottoTicketMachine.issue(listOf(1, 2, 3, 4, 5, 6))
        val comparingIssue = LottoTicketMachine.issue(listOf(1, 2, 3, 4, 5, 6))

        val matchingCount = issue.matchingCount(comparingIssue)

        assertThat(matchingCount).isEqualTo(6)
    }
}
