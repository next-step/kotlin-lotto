package lotto.domain

import lotto.domain.LottoBall
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoBallTest {

    @Test
    fun `로또볼 객체는 검증된 객체만 생성된다`(){
        assertThrows<IllegalArgumentException> { LottoBall(0) }
        assertThrows<IllegalArgumentException> { LottoBall(50) }
    }
}
