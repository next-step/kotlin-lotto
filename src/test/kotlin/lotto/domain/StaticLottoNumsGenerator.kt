package lotto.domain

internal class StaticLottoNumsGenerator(private val nums: List<Int>) : LottoNumsGenerator {

    override fun generate(): LottoNums {
        return LottoNums(*nums.toIntArray())
    }
}
