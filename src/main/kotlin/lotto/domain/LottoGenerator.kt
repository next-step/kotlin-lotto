package lotto.domain

class LottoGenerator {
    fun generate(): Lotto {
        return (1..45).shuffled()
            .take(6)
            .sorted()
            .map { LottoNumber.of(it) }
            .let { Lotto(it) }
    }
}
