package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringsKtTest {
    @Test
    fun `delimiter 로 구분된 String 은 구분자로 구분되어 Integer List 가 나온다 구한다`() {
        val input = "1,2,3,4,5"
        val integers = input.getIntegersAfterSplit(",")
        assertThat(integers.size).isEqualTo(5)
        assertThat(integers.first()).isEqualTo(1)
        assertThat(integers.last()).isEqualTo(5)
    }

    @Test
    fun `delimiter 로 구분된 String 이 올바른 Integer 형태가 아닌 경우 IllegalArgumentException 발생한다`() {
        val input = "1!2!3!b!5"
        assertThrows<IllegalArgumentException> { input.getIntegersAfterSplit("!") }
    }
}
