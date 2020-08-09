package lotto

import stringAddCalculator.LottoNumber

class Lotto(vararg numbers: Int) {
    val lottoNumbers = numbers.map {
        LottoNumber(it)
    }.toSet()

    init {
        require(lottoNumbers.size == VALID_LOTTO_NUMBER) { INVALID_LOTTO_NUMBER_MESSAGE }
    }

    companion object {
        private const val VALID_LOTTO_NUMBER = 6
        private const val INVALID_LOTTO_NUMBER_MESSAGE = "로또는 중복되지 않은 6개의 숫자로 생성할 수 있습니다."
    }
}
