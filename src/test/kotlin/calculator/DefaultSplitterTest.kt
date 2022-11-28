package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefaultSplitterTest {

    @Test
    fun `입력값을 분해합니다`() {
        val splitter = DefaultSplitter()

        assertThat(splitter.split("1,2,3")).containsExactly("1", "2", "3")
    }
}
