package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `랜덤 번호로 로또를 생성한다`() {
        shouldNotThrowAny { LottoGenerator().get() }
    }
}
