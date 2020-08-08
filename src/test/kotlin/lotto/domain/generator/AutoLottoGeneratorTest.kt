package lotto.domain.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class AutoLottoGeneratorTest {

    @DisplayName("랜덤으로 6자리의 번호를 생성한다")
    @Test
    fun execute() {
        assertThat(AutoLottoGenerator.execute()).hasSize(6).allSatisfy { it in 1..45 }
    }
}
