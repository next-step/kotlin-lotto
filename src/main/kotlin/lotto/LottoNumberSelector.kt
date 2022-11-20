package lotto

import lotto.utils.RandomNumberGenerator

object LottoNumberSelector {
    private const val START_NUMBER = 1
    private const val END_NUMBER = 45
    private const val MAX_LOTTO_NUMBER_SIZE = 6

    fun select(): Set<Int> {
        val lottoNumbers = mutableSetOf<Int>()
        while (lottoNumbers.size < MAX_LOTTO_NUMBER_SIZE) {
            lottoNumbers.add(generateRandomNumber())
        }

        return lottoNumbers
    }

    private fun generateRandomNumber() = RandomNumberGenerator.generate(START_NUMBER..END_NUMBER)
}
