package caculator

internal class Number(val value: Int) {
    init {
        validate()
    }

    constructor(value: String) : this(
        value.toIntOrNull() ?: throw IllegalArgumentException("invalid string")
    )

    internal operator fun plus(number: Number): Number {
        return Number(this.value + number.value)
    }

    internal operator fun minus(number: Number): Number {
        return Number(this.value - number.value)
    }

    internal operator fun times(number: Number): Number {
        return Number(this.value * number.value)
    }

    internal operator fun div(number: Number): Number {
        return Number(this.value / number.value)
    }

    private fun validate() {
        require(this.value >= 0) {
            "number must be positive"
        }
    }

    companion object {
        val ZERO = Number(0)
    }
}
