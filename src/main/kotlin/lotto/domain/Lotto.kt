package lotto.domain

import lotto.constant.REQUIRED_LOTTO_SIZE

class Lotto(val lottoNumbers: Set<LottoNumber>) {
    constructor(vararg numbers: Int) : this(numbers.map(::LottoNumber).toSet())

    init {
        require(lottoNumbers.size == REQUIRED_LOTTO_SIZE) {
            ERROR_WRONG_NUMBER_COUNT
        }
    }

    fun getIntersectSize(winningLotto: Lotto): Int {
        val lottoNumbers: Set<LottoNumber> = lottoNumbers
        val winningLottoNumbers: Set<LottoNumber> = winningLotto.lottoNumbers
        return lottoNumbers.intersect(winningLottoNumbers).size
    }

    companion object {
        private const val ERROR_WRONG_NUMBER_COUNT = "정확히 6개의 숫자를 입력해야 합니다."
    }
}
