package calculate

class Adder(inputs: List<Int>) {
    val result = add(inputs)

    private fun add(inputs: List<Int>): Int {
        inputs.forEach {
            require(it > CALCULATOR_NUMBER_MIN_NUMBER) { "${CALCULATOR_NUMBER_MIN_NUMBER}보다 큰 숫자만 더할 수 있습니다." }
        }
        return inputs.sum()
    }

    companion object {
        private const val CALCULATOR_NUMBER_MIN_NUMBER = 0
    }
}
