package lotto.domain

object LottoListGenerator {
    fun generateLottoList(lottoCount: Long, lottoGenerator: LottoGenerator): LottoList {
        val lottoList = (1..lottoCount).map {
            lottoGenerator.generateLottoFromNumbers(
                LottoNumber.possibleNumbers
            )
        }
        return LottoList(lottoList)
    }
}
