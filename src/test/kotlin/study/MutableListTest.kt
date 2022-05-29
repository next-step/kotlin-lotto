package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MutableListTest {

    @Test
    internal fun `mutableList를 copy하면 snapshot으로 복사된다`() {
        val sourceList = mutableListOf(1, 2, 3)
        val copyList = sourceList.toList()

        sourceList.add(4)

        assertThat(sourceList).isNotEqualTo(copyList)
        assertThat(sourceList).hasSize(4)
        assertThat(copyList).hasSize(3)
    }
}
