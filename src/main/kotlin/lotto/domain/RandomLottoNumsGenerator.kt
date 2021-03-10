package lotto.domain

internal class RandomLottoNumsGenerator : LottoNumsGenerator {
    override fun generate(): Lotto {
        val lottoNums = (LottoNum.MIN_NUM..LottoNum.MAX_NUM).shuffled()
            .subList(0, Lotto.NUM_SIZE).map { LottoNum.from(it) }
        return Lotto(lottoNums)
    }
}
