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
        val selectedNumber = numbers.shuffled()[PICK_INDEX]
        numbers.remove(selectedNumber)
        return selectedNumber
    }


    companion object {
        private const val PICK_INDEX: Int = 0
    }
}
