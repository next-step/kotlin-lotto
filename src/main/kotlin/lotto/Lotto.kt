package lotto

import stringAddCalculator.LottoNumber

class Lotto(vararg numbers: Int) {
    val lottoNumbers = numbers.map {
        LottoNumber(it)
    }.toSet()

    init {
        require(numbers.size == VALID_LOTTO_NUMBER) { INVALID_SIZE_MESSAGE }
        require(lottoNumbers.size == VALID_LOTTO_NUMBER) { DUPLICATE_MESSAGE }
    }

    companion object {
        private const val VALID_LOTTO_NUMBER = 6
        const val INVALID_SIZE_MESSAGE = "로또는 6개의 숫자로 생성할 수 있습니다."
        const val DUPLICATE_MESSAGE = "로또는 중복되지 않은 숫자로만 생성할 수 있습니다."
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Lotto
        if (lottoNumbers != other.lottoNumbers) return false
        return true
    }

    override fun hashCode(): Int {
        return lottoNumbers.hashCode()
    }
}
