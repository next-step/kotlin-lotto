package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoMachineTest {

    @Test
    fun `로또생성테스트`() {
        val lottoMaker = object : LottoMaker {
            override fun make(): Lotto {
                val lottoNumbers = listOf(
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(1),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
                return Lotto(lottoNumbers)
            }
        }
        val lottoMachine = LottoMachine(lottoMaker)

        val buyLotto = lottoMachine.buyLotto(1)
        val lotto = buyLotto.get[0]

        assertThat(lotto.get.size).isEqualTo(6)
    }
}
