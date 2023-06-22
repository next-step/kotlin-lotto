package lotto.domain

class ManualLottoGenerator : LottoGenerator {
    override fun generate(numbers: List<Int>): Lotto {
        return Lotto(numbers.map { LottoNumber(it) })
    }
}
