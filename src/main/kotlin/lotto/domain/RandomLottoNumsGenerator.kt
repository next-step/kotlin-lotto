package lotto.domain

internal class RandomLottoNumsGenerator : LottoNumsGenerator {
    override fun generate(): List<LottoNum> {
        return (LottoNum.MIN_NUM..LottoNum.MAX_NUM).shuffled()
            .subList(0, Lotto.NUM_SIZE)
            .map { LottoNum.from(it) }
    }
}
