package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoBuyerTest {

    @Test
    fun `로또를 구매한다`() {
        val lottoBuyer = LottoBuyer(LottoNumbersGeneratorStub)
        val lottos = lottoBuyer.buyLotto(LottoMoney(14000))
        assertThat(lottos).hasSize(14)
        assertThat(lottos[0].numbers).containsExactly(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
    }
}
