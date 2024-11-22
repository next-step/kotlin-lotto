package lotto

import lotto.domain.Lotto
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 번호는 1부터 45까지 번호 중 6개의 랜덤 조합이다`() {
        val lotto = Lotto()
        lotto.numbers.all { it in (1..45) }
    }
}
