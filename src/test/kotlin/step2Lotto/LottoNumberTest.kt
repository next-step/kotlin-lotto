package step2Lotto

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test
import step2Lotto.domain.dto.Lotto

class LottoNumberTest {
    @Test
    fun `로또 번호 검증 1~45 이외의 번호로 생성 시 예외발생`() {
        shouldThrow<IllegalStateException> {
            Lotto(arrayOf(1, 2, 3, 4, 5, 46))
        }
    }
}
