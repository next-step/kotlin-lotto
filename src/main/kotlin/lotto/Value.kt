package lotto

data class Value(val money: Int) {

    init {
        require(money >= 0)
        require(money % 1000 == 0)
    }

    fun add(value: Value): Value {
        return Value(money + value.money)
    }

    companion object {
        fun byInput(input: String): Value {
            val money = input.toIntOrNull()
            require(money != null)
            return Value(money)
        }
    }
}
