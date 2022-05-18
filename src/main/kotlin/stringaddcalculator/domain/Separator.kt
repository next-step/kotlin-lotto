package stringaddcalculator.domain

class Separator(val value: String) {
    init {
        require(value.isNotEmpty()) { "구분자의 길이는 1 이상이어야 합니다" }
    }
}
