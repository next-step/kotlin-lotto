package kotlintest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KotlinTest {
    @Test
    fun setTest() {
        val set = setOf(1, 2, 3, 4, 5, 5)
        assertThat(set.size).isEqualTo(5)
    }
}
