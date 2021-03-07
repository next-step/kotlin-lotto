package caculator

internal data class NaturalNumbers(private val naturalNumbers: List<NaturalNumber>) {

    internal fun sum(): Int {
        return this.naturalNumbers.fold(NaturalNumber.ZERO) { total, num -> total + num }.value
    }
}
