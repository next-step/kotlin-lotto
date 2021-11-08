package lotto.model

/**
 * 로또 생성 개수 관리
 * */
class LottoCount(
    private val maxCount: Int,
) {

    fun createLottoNumber(count: Int = MIN_COUNT): Int {
        return when {
            maxCount < MIN_COUNT -> MIN_COUNT
            count > maxCount -> maxCount
            else -> count
        }
    }

    companion object {
        private const val MIN_COUNT = 0
    }
}
