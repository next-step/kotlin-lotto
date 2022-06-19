package lotto.component

import lotto.domain.Lotto
import lotto.domain.LottoMoney
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

private operator fun LottoMoney.div(number: Int): Int = this.money / number

object LottoFactory {
    fun createLottoList(inputMoney: LottoMoney, lottoNumberGenerator: LottoNumberGenerator): List<Lotto> {
        val lottoCount = inputMoney / Lotto.PRICE
        val lottoList: MutableList<Lotto> = mutableListOf()

        for (i in 1..lottoCount) {
            val lotto = Lotto.create(lottoNumberGenerator.generate())
            lottoList.add(lotto)
        }

        return lottoList
    }

    fun createWinningLotto(winningLottoNumbers: List<Int>): WinningLotto {
        return WinningLotto.create(winningLottoNumbers.map { LottoNumber.from(it) })
    }
}
