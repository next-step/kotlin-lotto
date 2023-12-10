package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBER_DELIMITER

class ManualLotto {
    val lottos: MutableList<Lotto> = mutableListOf()

    fun initLottoNumbers(input: String): ManualLotto {
        val numbers = input.split(LOTTO_NUMBER_DELIMITER).map { it.trim() }
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 6개여야 합니다." }
        val lottoNumbers = LottoNumber.of(numbers)
        return addLottoNumbers(lottoNumbers)
    }

    fun addLottoNumbers(numbers: List<LottoNumber>): ManualLotto {
        lottos.add(Lotto(numbers))
        return this
    }
    
    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
