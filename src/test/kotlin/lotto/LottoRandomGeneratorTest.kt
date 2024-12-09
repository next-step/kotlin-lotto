package lotto

import lotto.domain.LottoRandomGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.RepeatedTest

class LottoRandomGeneratorTest {
    @RepeatedTest(100)
    fun `랜덤 로또 번호를 생성한다`() {
        val randomLotto = LottoRandomGenerator.randomGenerate()
        assertEquals(6, randomLotto.numbers.distinct().size)
    }
}