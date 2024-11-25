package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoResult

class LottoView {
    companion object {
        fun drawLottos(lottoResult: LottoResult) {
            lottoResult.lottos.drawLottos()
        }

        fun drawLotto(lotto: Lotto) {
            println(lotto.numbers.lottoNumbers.map { it.number }.joinToString(prefix = "[", postfix = "]", separator = ","))
        }

        fun drawResultMap(lottoResult: LottoResult) {
            println("당첨 통계")
            println("---------")
            lottoResult.lottoMatchMap.drawMatchMap()
        }

        fun drawProfitRate(lottoResult: LottoResult) {
            println("총 수익률은 ${lottoResult.profitRate}입니다.")
        }
    }
}
