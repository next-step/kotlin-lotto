package lotto.domain

internal class StaticLottoNumsGenerator(private val nums: List<Int>) : LottoNumsGenerator {

    override fun generate(): Lotto {
        return Lotto.createAutoLotto(nums)
    }
}
