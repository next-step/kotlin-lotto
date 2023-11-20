package me.parker.nextstep.kotlinlotto.domain

class LottoNumbers(val values: Set<LottoNumber>) {
    init {
        require(values.size == LOTTO_NUMBERS_SIZE) { "로또 번호는 중복되지 않은 $LOTTO_NUMBERS_SIZE 개를 가지고 있어야합니다." }
    }

    constructor(generationRule: LottoNumbersGenerationRule) : this(generationRule.generate().toSet())

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6
        val lottoNumbersCandidates: List<LottoNumber> = (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)
            .map { LottoNumber(it) }
    }
}

interface LottoNumbersGenerationRule {

    fun generate(): List<LottoNumber>
}

class RandomLottoNumbersGenerationRule : LottoNumbersGenerationRule {

    override fun generate(): List<LottoNumber> {
        return LottoNumbers.lottoNumbersCandidates.shuffled().take(6)
    }
}

class ManualLottoNumbersGenerationRule(private val numbers: List<Int>) : LottoNumbersGenerationRule {

    override fun generate(): List<LottoNumber> {
        return numbers.map { LottoNumber(it) }
    }
}
