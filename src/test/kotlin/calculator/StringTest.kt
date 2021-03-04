package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun test() {
        assertThat("1,2".contains(",")).isTrue()
        assertThat("1,2".replace(",".toRegex(),"")).isEqualTo("12")
    }
}
