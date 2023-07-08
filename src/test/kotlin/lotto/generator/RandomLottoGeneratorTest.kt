package lotto.generator

import io.kotest.assertions.throwables.shouldNotThrowAny
import org.junit.jupiter.api.Test

class RandomLottoGeneratorTest {

    @Test
    fun `랜덤 번호로 로또를 생성한다`() {
        shouldNotThrowAny { RandomLottoGenerator().get() }
    }
}
