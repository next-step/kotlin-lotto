package calculator

@JvmInline
value class PositiveNumber(val value: Int) {

    init {
        require(value >= 0)
    }
}

fun List<PositiveNumber>.sum(): Int {
    var sum: Int = 0
    for (element in this) {
        sum += element.value
    }
    return sum
}
