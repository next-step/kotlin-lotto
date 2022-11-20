package lotto

import lotto.util.RandomNumberGenerator

class AutoLottoTicket : LottoTicket {
    override val lottoNumbers: Set<LottoNumber>

    init {
        val lottoNumbers = mutableSetOf<LottoNumber>()
        while (lottoNumbers.size < LOTTO_NUMBER_COUNT) {
            val randomNumber = RandomNumberGenerator.generate(START_NUMBER..END_NUMBER)
            val lottoNumber = LottoNumber(randomNumber)
            lottoNumbers.add(lottoNumber)
        }
        this.lottoNumbers = lottoNumbers
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
    }
}
