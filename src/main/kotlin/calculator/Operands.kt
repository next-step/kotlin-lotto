package calculator

fun List<Operand>.sum(): Operand {
    var sum: Operand = Operand.ZERO
    for (element in this) {
        sum += element
    }
    return sum
}
