package lotto.domain

import lotto.model.LottoNumber

class LottoNumbers(
    val value: List<LottoNumber>,
) {
    init {
        require(value.size == NUMBER_OF_LOTTO_DIGIT) { "로또 번호는 ${NUMBER_OF_LOTTO_DIGIT}개의 숫자로 구성되어야 합니다." }
        require(value.distinct().size == NUMBER_OF_LOTTO_DIGIT) { "로또 번호는 중복되는 숫자가 없어야 합니다." }
    }

    fun contains(lottoNumber: LottoNumber): Boolean = value.contains(lottoNumber)

    companion object {
        const val NUMBER_OF_LOTTO_DIGIT = 6
    }
}
