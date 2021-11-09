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
            maxCount < MIN_COUNT -> MIN_COUNT // 최대 개수가 음수인 경우 0반환
            count > maxCount -> maxCount // 입력 개수가 최대 개수보다 많은 경우 최대 개수 반환
            else -> count
        }
    }

    companion object {
        private const val MIN_COUNT = 0
    }
}
