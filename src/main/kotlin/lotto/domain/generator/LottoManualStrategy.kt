package lotto.domain.generator

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.exception.NotSupportedException

class LottoManualStrategy : LottoGeneratorStrategy {

    override fun generateManual(manualNumbers: List<String>): List<Lotto> {
        val manualLottos = mutableListOf<Lotto>()
        for (manualNumber in manualNumbers) {
            val numbers: List<String> = manualNumber.split(DELIMITERS)
            val manualLottoNumbers: List<LottoNumber> = numbers.map {
                LottoNumber.valueOf(it.toInt())
            }.toList()
            manualLottos.add(Lotto(manualLottoNumbers))
        }
        return manualLottos
    }

    override fun generateAuto(lottoCount: Int): List<Lotto> {
        throw NotSupportedException()
    }

    companion object {
        private const val DELIMITERS = ", "
    }
}
