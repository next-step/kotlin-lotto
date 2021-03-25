package lotto.model.number

object LottoNumbersFactory {
    fun create(lottoNumbers: Set<LottoNumber>): LottoNumbers {
        return LottoNumbers(lottoNumbers.toSet())
    }

    fun create(lottoNumbers: List<Int>): LottoNumbers {
        return LottoNumbers(lottoNumbers.map { LottoNumber.get(it) }.toSet())
    }
}
