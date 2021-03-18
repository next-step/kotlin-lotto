package domain

class Money(val value: Int) {
    init {
        if (value <= 0) throw IllegalArgumentException()
    }
}
