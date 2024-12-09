package lotto.domain

import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {
    @Test
    fun `로또 번호 자동 생성은 1부터 45사이의 6개의 숫자로 이루어져야한다`() {
        (1..45).toSet().containsAll(generateLottoNumbers()) shouldBeEqual true
    }
}
