package lotto.domain.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class AutoLottoTicketGeneratorTest {

    @DisplayName("랜덤으로 6자리의 번호를 생성한다")
    @Test
    fun execute() {
        assertThat(AutoLottoGenerator.execute()?.numbers).allSatisfy { it.value in 1..45 }
    }
}
