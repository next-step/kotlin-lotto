package lotto.domain

class LottoGenerator {

    fun generate(): Lotto {
        val lottoNumbers = DEFAULT_RANGE.shuffled().subList(0, 6).sorted().map { LottoNumber(it) }.toSet()
        return Lotto(lottoNumbers)
    }

    companion object {
        val DEFAULT_RANGE = IntRange(1, 45)
    }
}
