package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachine {

    fun buyLotto(buyingPrice: Int): List<Lotto> {
        val lottoCount: Int = buyingPrice / Lotto.LOTTO_PRICE

        return (0 until lottoCount).map { Lotto(*this.getLottoNumberList()) }
    }

    private fun getLottoNumber(): Int = (Math.random() * Lotto.LOTTO_NUMBER_MAX).toInt() + Lotto.LOTTO_NUMBER_MIN

    private fun getLottoNumberList(): IntArray {
        val lottoNumberList: MutableList<Int> = mutableListOf()

        while (lottoNumberList.size < LOTTO_NUMBER_COUNT_MAX) {
            val lottoNumber: Int = this.getLottoNumber()

            if (!lottoNumberList.contains(lottoNumber)) {
                lottoNumberList.add(lottoNumber)
            }
        }

        return lottoNumberList.toIntArray()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT_MAX: Int = 6
    }
}

class LottoMachineTest {

    @Test
    fun `로또를 구매할 수 있다`() {
        val lottoMachine: LottoMachine = LottoMachine()

        val lottoList: List<Lotto> = lottoMachine.buyLotto(Lotto.LOTTO_PRICE)

        assertThat(lottoList).hasSize(1)
    }
}
