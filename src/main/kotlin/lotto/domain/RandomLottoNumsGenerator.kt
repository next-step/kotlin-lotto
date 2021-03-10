package lotto.domain

internal class RandomLottoNumsGenerator : LottoNumsGenerator {
    override fun generate(): LottoNums {
        val lottoNums = (LottoNum.MIN_NUM..LottoNum.MAX_NUM).shuffled()
            .subList(0, LottoNums.NUM_SIZE).map { LottoNum.of(it) }
        return LottoNums(lottoNums)
    }
}
