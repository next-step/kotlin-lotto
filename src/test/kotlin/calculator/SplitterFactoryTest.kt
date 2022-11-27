package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SplitterFactoryTest {

    @Test
    fun `입력값에 따라 적합한 문자열 계산기를 반환합니다`() {
        val splitterFactory = SplitterFactory()

        assertThat(splitterFactory.getSplitter("1:2,3")).isInstanceOf(DefaultSplitter::class.java)
        assertThat(splitterFactory.getSplitter("//$\n1$2$3")).isInstanceOf(CustomSplitter::class.java)
    }
}
