package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult

class LottoView {
    fun drawLottos(lottoResult: LottoResult) {
        lottoResult.lottos.forEach { drawLotto(it) }
    }

    private fun drawLotto(lotto: Lotto) {
        lotto.numbers.joinToString(prefix = "[", postfix = "]", separator = ",")
    }

    fun drawResultMap(lottoResult: LottoResult) {
        println("당첨 통계")
        println("---------")
        lottoResult.lottoResultMap.forEach { println("${it.key}개 일치 : ${it.value}개") }
    }

    fun drawProfitRate(lottoResult: LottoResult) {
        println("총 수익률은 ${lottoResult.profitRate}입니다.")
    }
}
