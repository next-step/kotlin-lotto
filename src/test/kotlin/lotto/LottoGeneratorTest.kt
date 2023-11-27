package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    
    @Test
    fun `로또 생성기는 숫자 6개를 생성한다`() {
        val lottoGenerator = LottoGenerator()
        val lotto = lottoGenerator.generate()
        lotto.size shouldBe 6
    }

    @Test
    fun `로또 생성기는 숫자가 겹치지 않는다`() {
        val lottoGenerator = LottoGenerator()
        val lotto = lottoGenerator.generate()
        lotto.distinct().size shouldBe 6
    }
    
}
