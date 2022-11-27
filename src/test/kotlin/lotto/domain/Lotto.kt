package lotto.domain

import lotto.domain.Lotto
import lotto.domain.LottoBall
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또는 검증된 로또 객체만 생성된다`(){
        assertThrows<IllegalArgumentException> { Lotto(listOf(LottoBall(1),LottoBall(2),LottoBall(3),LottoBall(4),LottoBall(5))) }
    }
}
