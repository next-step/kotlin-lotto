package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class ManualLottoTicketGeneratorTest {
    @Test
    fun `수량에 맞는 수동 번호 로또를 발행한다`() {
        Assertions.assertThat(
            ManualLottoTicketGenerator(
                listOf(
                    "1, 2, 3, 4, 5, 6",
                    "11, 12, 13, 14, 15, 16"
                )
            ).tickets.size
        ).isSameAs(2)
    }
}
