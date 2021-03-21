package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {

    private val lotto = Lotto(
        setOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        )
    )

    @Test
    fun `생성테스트 보너스 넘버는 Lotto의 번호와 중복될 수 없다 중복되지 않는 경우 생성할 수 있다`() {
        val number7 = LottoNumber.of(7)
        assertDoesNotThrow { WinningLotto(lotto, number7) }
    }

    @Test
    fun `생성테스트 보너스 넘버는 Lotto의 번호와 중복될 수 없다 중복되는 경우 생성할 수 없다`() {
        val number6 = LottoNumber.of(6)
        assertThrows<IllegalArgumentException> { WinningLotto(lotto, number6) }
    }
}
