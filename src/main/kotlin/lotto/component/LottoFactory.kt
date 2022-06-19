package lotto.component

import lotto.domain.Lotto

object LottoFactory {
    fun createLottoList(lottoCount: Int, lottoNumberGenerator: LottoNumberGenerator): List<Lotto> {
        val lottoList: MutableList<Lotto> = mutableListOf()

        for (i in 1..lottoCount) {
            val lotto = Lotto.create(lottoNumberGenerator.generate())
            lottoList.add(lotto)
        }

        return lottoList
    }
}
