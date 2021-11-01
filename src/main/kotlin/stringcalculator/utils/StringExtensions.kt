package stringcalculator.utils

fun String.toPositiveInt(): Int {
    val int = this.toInt()
    require(int >= 0) { "$int is not positive." }
    return int
}
