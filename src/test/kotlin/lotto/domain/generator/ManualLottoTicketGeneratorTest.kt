package lotto.domain.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ManualLottoTicketGeneratorTest {

    @DisplayName("수동으로 로또를 생성한다")
    @Test
    fun execute() {
        assertThat(ManualLottoGenerator("1, 2, 3, 4, 5, 6").execute()).containsAnyOf(1, 2, 3, 4, 5, 6)
    }

    @DisplayName("수동 입력 시 1 이상 45 이하의 숫자만 당첨 번호로 사용이 가능하다")
    @Test
    fun numberInRange() {
        assertThat(ManualLottoGenerator.isAcceptable("0, 4, 5, 6, 7, 49")).isFalse()
    }

    @DisplayName("당첨 번호에 중복이 있으면 안된다")
    @Test
    fun noDuplication() {
        assertThat(ManualLottoGenerator.isAcceptable("2, 4, 5, 6, 45, 45")).isFalse()
    }
}
