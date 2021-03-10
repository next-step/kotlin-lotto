package lotto.domain

object RandomLottoGenerator {

    fun generate(): Lotto {
        return Lotto(
            LottoNumber.RANGE.toList()
                .shuffled()
                .take(Lotto.SIZE)
                .map { LottoNumber.of(it) }
                .toSortedSet()
        )
    }
}
