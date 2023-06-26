package lotto.model

import lotto.domain.LottoRanking

class LottoResultPrintModel(val correctCount: Int, val price: Int, val count: Int) {

    companion object {
        fun ofList(lottoResult: Map<LottoRanking, Int>): List<LottoResultPrintModel?> {
            return LottoRanking.values()
                .filter { ranking -> ranking != LottoRanking.MISS }
                .sortedBy { it }
                .map {
                    lottoResult[it]?.let { count -> LottoResultPrintModel(it.correctCount, it.price, count) }
                }
        }
    }
}
