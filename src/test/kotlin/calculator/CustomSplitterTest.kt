package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomSplitterTest {

    @Test
    fun `구분자 포함 여부를 반환합니다`() {
        assertThat(CustomSplitter.containsSplitter("//$\n1$2")).isTrue
        assertThat(CustomSplitter.containsSplitter("1;2")).isFalse
    }

    @Test
    fun `입력값을 분해합니다`() {
        val splitter = CustomSplitter()

        assertThat(splitter.split("//$\n1$2")).containsExactly("1", "2")
    }
}
