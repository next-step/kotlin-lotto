package lotto.utils

import lotto.domain.Lotto

class LottoGenerator(
    private val numbers: MutableList<Int>
) {
    fun getLottoNumbers(): List<Int> {
        val numberSet = mutableSetOf<Int>()
        do {
            numberSet.add(getLottoNumber())
        } while (numberSet.size < Lotto.COLLECT_LOTTO_SIZE)
        return numberSet.sorted()
    }

    private fun getLottoNumber(): Int {
        return numbers.shuffled()[PICK_INDEX]
    }

    companion object {
        private const val PICK_INDEX: Int = 0
    }
}
