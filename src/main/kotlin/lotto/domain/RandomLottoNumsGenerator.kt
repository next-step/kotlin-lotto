package lotto.domain

internal class RandomLottoNumsGenerator : LottoNumsGenerator {
    override fun generate(): LottoNums {
        val nums: List<Int> = (LottoNum.MIN_NUM..LottoNum.MAX_NUM).shuffled().subList(0, LottoNums.NUM_SIZE)
        return LottoNums(*nums.toIntArray())
    }
}
