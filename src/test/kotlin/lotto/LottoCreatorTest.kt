package lotto

import lotto.LottoCreator.issue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import racing.domain.gamerule.IssueStrategy
import racing.domain.gamerule.RandomIssueStrategy

class LottoCreatorTest {

    @Test
    fun `로또를 설정한 횟수에 맞게 랜덤하게 발급한다`() {
        val count = 3

        var strategy = RandomIssueStrategy(count)
        assertThat(issue(count, strategy).size).isEqualTo(count)
    }

    @Test
    fun `발급된 숫자에 중복이 없어야 한다`() {
        var strategy = object : IssueStrategy {
            override fun issue(): List<List<Int>> {
                return listOf(listOf(1, 2, 3, 3, 4, 5))
            }
        }

        val randomIssuedList = issue(1, strategy)
        assertThat(randomIssuedList.distinct().size).isEqualTo(randomIssuedList.size)
    }

    @Test
    fun `설정한 수가 음수인 경우 IllegalArgumentException 오류를 던져야 한다`() {
        var strategy = object : IssueStrategy {
            override fun issue(): List<List<Int>> {
                return listOf(listOf(1, 2, 3, 4, 5, 6))
            }
        }

        assertThrows(IllegalArgumentException::class.java) {
            issue(-1, strategy)
        }
    }
}
