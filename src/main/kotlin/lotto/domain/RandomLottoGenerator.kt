package lotto.domain

object RandomLottoGenerator {

    fun generate(): Lotto {
        return Lotto(
            LottoNumber.RANGE.toList()
                .shuffled()
                .subList(0, Lotto.SIZE)
                .sorted()
                .map { LottoNumber.of(it) }
                .toSet()
        )
    }
}
