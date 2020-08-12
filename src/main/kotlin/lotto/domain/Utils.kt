package lotto.domain

val NUMERIC_REGEX = Regex("[0-9]*")

fun validateBonusNumber(text: String?): Int {
    if (text.isNullOrBlank()) {
        println("잘못된 보너스 번호 입력하셨습니다.")
        return 0
    }
    if (NUMERIC_REGEX.matches(text) && text.toInt() != 0) {
        return text.toInt()
    }

    return 0
}

fun validateWinningNumber(numbers: String?): Set<String>? {
    if (numbers.isNullOrBlank()) {
        println("잘못된 당첨 번호 입니다.")
        return null
    }

    val numbers = splitNumbers(numbers)
    numbers.map {
        if (!NUMERIC_REGEX.matches(it)) {
            println("잘못된 당첨 번호 입니다.")
            return null
        }
    }

    if (numbers.size != 6) {
        println("잘못된 당첨 번호 입니다.")
        return null
    }

    return numbers
}

fun validate(price: String?): Int {
    if (price.isNullOrBlank()) {
        println("잘못된 구입 가격을 입력하셨습니다.")
        return 0
    }
    if (NUMERIC_REGEX.matches(price)) {
        return price.toInt()
    }

    println("잘못된 구입 가격을 입력하셨습니다.")
    return 0
}

fun splitNumbers(numbers: String) = numbers
    .split(",")
    .filter { it.isNotBlank() }
    .map { it.trim() }
    .toSet()
