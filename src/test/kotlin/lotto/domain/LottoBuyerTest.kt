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
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        )
    }
}
