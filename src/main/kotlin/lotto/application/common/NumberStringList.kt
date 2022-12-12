package lotto.application.common

class NumberStringList(
    string: String
) {
    val list = string.split(",").map { NumberString(it.trim()) }

    fun toNumberList(): List<Number> {
        return list.map { it.toNumber() }
    }
}
