package lotto.domain

import java.util.*

/**
 * 로또 1게임
 */
data class LottoNumberPackage(val numbers: Set<LottoNumber>) {
    fun size(): Int {
        return numbers.size
    }

    fun getSortedNumbers(): SortedSet<Int> {
        return numbers
            .map { it.value }
            .toSortedSet(compareBy { it })
    }

    init {
        require(numbers.size == LOTTO_GAME_NUMBER_COUNT) { INVALID_LOTTO_GAME_NUMBER_COUNT_MESSAGE }
    }

    companion object {
        const val LOTTO_GAME_NUMBER_COUNT = 6
        private const val INVALID_LOTTO_GAME_NUMBER_COUNT_MESSAGE =
            "잘못된 로또 번호 개수입니다.(번호 ${LOTTO_GAME_NUMBER_COUNT}개 입력)"
    }
}
