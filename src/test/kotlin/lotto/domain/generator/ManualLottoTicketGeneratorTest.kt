package lotto.domain.generator

import lotto.domain.lotto.LottoNumber
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ManualLottoTicketGeneratorTest {

    @DisplayName("수동으로 로또를 생성한다")
    @Test
    fun execute() {
        assertThat(ManualLottoGenerator.execute("1, 2, 3, 4, 5, 6")?.numbers).containsAnyOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
    }

    @DisplayName("유효하지 않은 문자 포함시 예외를 발생시킨다")
    @Test
    fun numberInRange() {
        Assertions.assertThatThrownBy {
            ManualLottoGenerator.execute("1, 2, 3, 4, A, 6")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
