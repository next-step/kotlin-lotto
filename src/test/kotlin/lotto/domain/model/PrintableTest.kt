package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrintableTest {
    @Test
    fun `Printable을 통해 출력이 가능한 모델임을 표시하고, 출력하게 될 텍스트를 구현한다`() {
        val printable = object : Printable {
            override fun toPrintText(): String {
                return "Printable"
            }
        }

        assertThat(printable.toPrintText()).isEqualTo("Printable")
    }
}
