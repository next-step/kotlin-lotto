package add_calculator

class PositiveNumber(val value: Int) {
    init {
        if (value < 0) throw RuntimeException()
    }
}
