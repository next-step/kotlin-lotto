package lotto

class LottoGenerator {
    fun get(): Lotto {
        return LottoNumber.NUMBER_RANGE
            .shuffled()
            .take(Lotto.LOTTO_NUMBER_SIZE)
            .sorted()
            .map(::LottoNumber)
            .let(::Lotto)
    }

}
