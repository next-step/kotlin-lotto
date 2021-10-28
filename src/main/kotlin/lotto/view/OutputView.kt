package lotto.view

import lotto.domain.Lotto

class OutputView {

    companion object {
        private const val SEPARATOR = ", "
        private const val PREFIX = "["
        private const val POSTFIX = "]"

        fun printBoughtLottos(lottos: List<Lotto>) {
            repeat(lottos.size) {
                val lotto: Lotto = lottos[it]
                println(lotto.lottoNumbers.joinToString(SEPARATOR, PREFIX, POSTFIX))
            }
        }
    }
}
