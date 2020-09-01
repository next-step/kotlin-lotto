package lotto.domain.generator

import lotto.domain.lotto.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ManualLottoTicketGeneratorTest {

    @DisplayName("수동으로 로또를 생성한다")
    @Test
    fun execute() {
        assertThat(ManualLottoGenerator.execute("1, 2, 3, 4, 5, 6")?.numbers).containsAnyOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        )
    }

    @DisplayName("유효하지 않은 문자 포함시 로또 생성에 실패한다")
    @Test
    fun numberInRange() {
        assertThat(ManualLottoGenerator.execute("1, 2, 3, 4, A, 6")).isNull()
    }
}
