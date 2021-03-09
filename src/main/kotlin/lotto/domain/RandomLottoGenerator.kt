package lotto.domain

object RandomLottoGenerator {

    fun generate(): Lotto {
        return Lotto(
            LottoNumber.RANGE.toList()
                .shuffled()
                .subList(0, Lotto.SIZE)
                .map { LottoNumber.of(it) }
                .toSortedSet()
        )
    }
}
