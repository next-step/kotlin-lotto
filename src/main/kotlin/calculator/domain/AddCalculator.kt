package calculator.domain

data class SumResult(val sumNumber: Int) {
    fun add(addNumber: Int): SumResult {
        return SumResult(sumNumber + addNumber)
    }
}

class AddCalculator {
    var sumResult = SumResult(0)
        private set

    fun add(input: Int?): AddCalculator {
        if (input == null) return this
        if (input < 0) throw RuntimeException("자연수로 입력해 주세요.")
        sumResult = sumResult.add(input)
        return this
    }

    fun getResult() = sumResult.sumNumber
}
