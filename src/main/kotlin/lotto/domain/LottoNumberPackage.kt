package lotto.domain

import java.util.SortedSet

/**
 * 로또 1게임
 */
data class LottoNumberPackage(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_GAME_NUMBER_COUNT) { INVALID_LOTTO_GAME_NUMBER_COUNT_MESSAGE }
    }

    fun size(): Int {
        return numbers.size
    }

    fun getSortedNumbers(): SortedSet<Int> {
        return numbers
            .map { it.value }
            .toSortedSet(compareBy { it })
    }

    fun getMatchedCount(winningNumberPackage: LottoNumberPackage): MatchedCount {
        return MatchedCount.of(numbers.intersect(winningNumberPackage.numbers).size)
    }

    fun matchedBonusNumber(bonusNumber: LottoNumber): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun getPrizeMoney(winningInfo: WinningInfo): Long {
        return LottoResultRank.getRank(getMatchedCount(winningInfo.winningNumberPackage), matchedBonusNumber(winningInfo.bonusNumber)).prizeMoney
    }

    companion object {
        private const val LOTTO_NUMBERS_SPLIT_DELIMITER = ","
        const val LOTTO_GAME_NUMBER_COUNT = 6
        private const val INVALID_LOTTO_GAME_NUMBER_COUNT_MESSAGE =
            "잘못된 로또 번호 개수입니다.(번호 ${LOTTO_GAME_NUMBER_COUNT}개 입력)"

        fun from(input: String): LottoNumberPackage {
            return LottoNumberPackage(getLottoNumbers(input))
        }

        private fun getLottoNumbers(input: String): Set<LottoNumber> {
            return input.split(LOTTO_NUMBERS_SPLIT_DELIMITER)
                .map { LottoNumber.from(it.trim()) }
                .toSet()
        }
    }
}
