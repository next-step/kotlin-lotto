package calculator

class PositiveNumber(private val value: UInt) {
    companion object {
        fun Iterable<PositiveNumber>.sum(): Int {
            var sum: UInt = 0u
            for (element in this) {
                sum += element.value
            }
            return sum.toInt()
        }
    }
}
