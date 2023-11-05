package lotto.domain

class FixedLottoGenerator : LottoGenerator {
    override fun generate(): Lotto {
        return Lotto(1, 2, 3, 4, 5, 6)
    }
}
