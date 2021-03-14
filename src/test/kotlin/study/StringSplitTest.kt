package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringSplitTest {
    @Test
    fun `두개를 나눠서 스플리트`() {
        val str = "1,2:3"

        print(str.split(Regex(",|:")))
        assertThat(str.split(Regex(",|:")))
            .containsExactlyInAnyOrder(
                "1",
                "2",
                "3"
            )
    }
}
