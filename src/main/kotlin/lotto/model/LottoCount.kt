package lotto.model

/**
 * 로또 생성 개수 관리
 * */
class LottoCount(
    private val maxCount: Int,
) {

    fun createLottoNumber(count: Int? = null): Int {
        return when {
            count == null -> maxCount
            maxCount < MIN_COUNT -> MIN_COUNT
            count < MIN_COUNT -> MIN_COUNT
            count > maxCount -> throw IllegalArgumentException("입력한 수만큼 로또를 생성할 수 없습니다.")
            else -> count
        }
    }

    companion object {
        private const val MIN_COUNT = 0
    }
}
