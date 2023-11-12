package lotto.domain

class LottoResult {
    private val result: HashMap<Int, Int> = hashMapOf()

    fun setLottoResult(matchedNumberCount: Int) {
        if (matchedNumberCount >= MINIMUM_MATCH_COUNT)
        result[matchedNumberCount] = result.getOrDefault(matchedNumberCount, 0) + 1
    }

    companion object {
        private const val MINIMUM_MATCH_COUNT: Int = 3
    }
}
