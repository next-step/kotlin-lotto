package lotto

import lotto.LottoCreator.issue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LottoCreatorTest {

    @Test
    fun `로또를 설정한 횟수에 맞게 랜덤하게 발급한다`() {
        val count = 3
        assertThat(issue(count).size).isEqualTo(count)
    }

    @Test
    fun `발급된 숫자에 중복이 없어야 한다`() {
        val randomIssuedList = issue(1)
        assertThat(randomIssuedList.distinct().size).isEqualTo(randomIssuedList.size)
    }

    @Test
    fun `설정한 수가 음수인 경우 IllegalArgumentException 오류를 던져야 한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            issue(-1)
        }
    }
}
