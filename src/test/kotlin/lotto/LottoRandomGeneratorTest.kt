package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoRandomGeneratorTest {
    @Test
    fun `랜덤 로또 번호를 생성한다`() {
        val randomLotto = LottoRandomGenerator().randomGenerate()
        assertEquals(6, randomLotto.numbers.size)
    }
}
