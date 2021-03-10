package lotto.domain

internal class StaticLottoNumsGenerator(private val nums: List<Int>) : LottoNumsGenerator {

    override fun generate(): List<LottoNum> {
        return this.nums.map { LottoNum.from(it) }
    }
}
