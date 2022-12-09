package simulator.lotto

class NumberGenerator(
    private val minNumber: Int,
    private val maxNumber: Int,
    private val count: Int
) {
    init {
        require((minNumber..maxNumber).count() >= count) {
            "최솟값과 최댓값까지의 숫자 갯수가 랜덤으로 추출할 숫자 갯수보다 작을순 없습니다."
        }

        check(maxNumber > minNumber) {
            "최댓값은 최솟값보다 작을수 없습니다."
        }
    }

    fun generate(): List<Int> {
        return (minNumber..maxNumber).shuffled()
            .slice(0 until count)
            .toList()
    }
}