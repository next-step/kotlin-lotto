package lotto.domain

class Lotto {
    val numbers: List<LottoNumber>

    constructor() {
        numbers = LottoPolicy.LOTTO_NUMBER_POOL.shuffled()
            .take(LottoPolicy.NUMBER_OF_LOTTO_NUMBER)
            .sorted().map { LottoNumber(it) }
    }

    constructor(numbers: List<Int>) {
        require(numbers.count() == LottoPolicy.NUMBER_OF_LOTTO_NUMBER)
        require(numbers.distinct().count() == LottoPolicy.NUMBER_OF_LOTTO_NUMBER)
        require(numbers.all { LottoPolicy.LOTTO_NUMBER_POOL.contains(it) })

        this.numbers = numbers.sorted().map { LottoNumber(it) }
    }

    fun contains(lottoNumber: LottoNumber) = numbers.contains(lottoNumber)
}
