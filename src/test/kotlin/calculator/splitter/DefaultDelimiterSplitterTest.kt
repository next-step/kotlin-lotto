package calculator.splitter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefaultDelimiterSplitterTest {
    @Test
    fun `커스텀 구분자가 주어지지 않을 경우 isApplicable 은 true 를 반환한다`() {
        assertThat(DefaultDelimiterSplitter.isApplicable("1,2:3")).isTrue
    }

    @Test
    fun `커스텀 구분자가 주어질 경우 isApplicable 은 false 를 반환한다`() {
        assertThat(DefaultDelimiterSplitter.isApplicable("//&\n1&2")).isFalse
    }

    @Test
    fun `기본 구분자로 숫자를 구분할 수 있다`() {
        assertThat(DefaultDelimiterSplitter.trySplit("1,2:3")).isEqualTo(listOf("1", "2", "3"))
    }
}
