package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class WinningLottoTest {

    @Test
    fun `당첨 번호에 보너스 번호가 포함되면 안된다`() {
        Assertions.assertThatThrownBy {
            WinningLotto(
                Lotto(
                    listOf(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(6)
                    )
                ), LottoNumber.from(6)
            )
        }.isInstanceOf(IllegalArgumentException::class.java)

    }
}
