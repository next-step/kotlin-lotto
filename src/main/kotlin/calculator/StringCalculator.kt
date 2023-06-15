package calculator

class StringCalculator(
    private val inputData: List<String>
) {
    init {
        checkNegativeNumber()
    }
    fun execute(): Int {
        return inputData.sumOf { it.toInt() }
    }

    private fun checkNegativeNumber() {
        inputData.forEach {
            if (it.toInt() < 0){
                throw RuntimeException("음수를 입력할 수 없습니다.")
            }
        }
    }
}
